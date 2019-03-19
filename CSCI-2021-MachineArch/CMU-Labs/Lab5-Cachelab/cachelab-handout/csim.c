/* Nathan Comer
 * ID: 5119060
 * csim.c - A cache simulator that can replay traces from Valgrind
 *     and output statistics such as number of hits, misses, and
 *     evictions.  The replacement policy is MRU.
 *
 *
 * The function printSummary() is given to print output.
 * Please use this function to print the number of hits, misses and evictions.
 * This is crucial for the driver to evaluate your work.
 */
#include <getopt.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <assert.h>
#include <math.h>
#include <limits.h>
#include <string.h>
#include <errno.h>
#include "cachelab.h"

//#define DEBUG_ON
#define ADDRESS_LENGTH 64

/* Type: Memory address */
typedef unsigned long long int mem_addr_t;

/* Type: Cache line
   MRU is a counter used to implement MRU replacement policy  */
typedef struct cache_line {
    char valid;
    mem_addr_t tag;
    unsigned long long int mru;
} cache_line_t;

typedef cache_line_t* cache_set_t;
typedef cache_set_t* cache_t;

/* Globals set by command line args */
int verbosity = 0; /* print trace if set */
int s = 0; /* set index bits */
int b = 0; /* block offset bits */
int E = 0; /* associativity */
char* trace_file = NULL;

/* Derived from command line args */
int S; /* number of sets */
int B; /* block size (bytes) */

/* Counters used to record cache statistics */
int miss_count = 0;
int hit_count = 0;
int eviction_count = 0;
unsigned long long int mru_counter = 1;

/* The cache we are simulating */
cache_t cache;
mem_addr_t set_index_mask = 0;

/*
 * initCache - Allocate memory, write 0's for valid and tag and MRU
 * also computes the set_index_mask
 */
void initCache()
{
	int i, j;

  // Set the mask so we can find the set number from an address
  set_index_mask = S - 1;

  // Allocate memory for the cache
	cache = malloc(S * sizeof(*cache));

	for (i=0; i<S; i++){

    // Allocate memory for each line
    cache[i] = calloc(E, sizeof(*cache[i]));

    for (j=0; j<E; j++){

      // Set the mru value for each line to a large number
      // so empty lines will be filled before evicting
      cache[i][j].mru = 0xffffffff;
    }
 }
}


/*
 * freeCache - free allocated memory
 */
void freeCache()
{
    int i;
    for (i=0; i<S; i++){
        free(cache[i]);
    }
    free(cache);
}


/*
 * accessData - Access data at memory address addr.
 *   If it is already in cache, increast hit_count
 *   If it is not in cache, bring it in cache, increase miss count.
 *   Also increase eviction_count if a line is evicted.
 */
void accessData(mem_addr_t addr)
{
	int i;

  // Get the set number from the address
	int set_index = ((addr >> b) & set_index_mask);

  // Get the tag from the address
	mem_addr_t tag = (addr >> (b+s));

  // Traverse the lines of the set
	for (i=0; i<E; i++){

    // Check if the line is a hit (valid line with matching tag)
		if ((cache[set_index][i].tag == tag) && (cache[set_index][i].valid == 1)){
			hit_count++;

      // Set a new mru value for the line being it was just used
			cache[set_index][i].mru = mru_counter++;
			return;
		}
	}

  // The address is not in the cache so we must add it
	miss_count++;

  // evict_index to hold the line index for the mru line
  int evict_index = 0;

  // mru_temp to hold largest mru value
	unsigned long long int mru_temp = 0;

  // for loop finds the mru line and its index
	for (i=0; i<E; i++){

    // if the line being accessed has a larger mru value it has been accessed more recently
		if (cache[set_index][i].mru > mru_temp){

      // therefore update mru_temp and store the line index in evict_index
			evict_index = i;
			mru_temp = cache[set_index][i].mru;
		}
	}

  // if the line is valid than it already contains data thus we're evicting that data
	if (cache[set_index][evict_index].valid == 1){
		eviction_count++;
	}

  // add our new line to the cache at the index of the mru line in the set
	cache[set_index][evict_index].valid = 1;
	cache[set_index][evict_index].tag = tag;
	cache[set_index][evict_index].mru = mru_counter++;
}


/*
 * replayTrace - replays the given trace file against the cache
 */
void replayTrace(char* trace_fn)
{
    char buf[1000];
    mem_addr_t addr=0;
    unsigned int len=0;
    FILE* trace_fp = fopen(trace_fn, "r");

    if(!trace_fp){
        fprintf(stderr, "%s: %s\n", trace_fn, strerror(errno));
        exit(1);
    }

    while( fgets(buf, 1000, trace_fp) != NULL) {
		    addr = 0;
		    len = 0;
        // If operation is L or S then load/store
		    if (buf[1] == 'S' || buf[1] == 'L'){
			      sscanf(buf+2, "%llx,%u", &addr , &len);
			      accessData(addr);
		    }
        // If operation is M then load and store so call accessData twice
		    if (buf[1] == 'M'){
          sscanf(buf+2, "%llx,%u", &addr , &len);
			    accessData(addr);
          accessData(addr);
        }
	}
    fclose(trace_fp);
}

/*
 * printUsage - Print usage info
 */
void printUsage(char* argv[])
{
    printf("Usage: %s [-hv] -s <num> -E <num> -b <num> -t <file>\n", argv[0]);
    printf("Options:\n");
    printf("  -h         Print this help message.\n");
    printf("  -v         Optional verbose flag.\n");
    printf("  -s <num>   Number of set index bits.\n");
    printf("  -E <num>   Number of lines per set.\n");
    printf("  -b <num>   Number of block offset bits.\n");
    printf("  -t <file>  Trace file.\n");
    printf("\nExamples:\n");
    printf("  linux>  %s -s 4 -E 1 -b 4 -t traces/yi.trace\n", argv[0]);
    printf("  linux>  %s -v -s 8 -E 2 -b 4 -t traces/yi.trace\n", argv[0]);
    exit(0);
}

/*
 * main - Main routine
 */
int main(int argc, char* argv[])
{
    char c;

    while( (c=getopt(argc,argv,"s:E:b:t:vh")) != -1){
        switch(c){
        case 's':
            s = atoi(optarg);
            break;
        case 'E':
            E = atoi(optarg);
            break;
        case 'b':
            b = atoi(optarg);
            break;
        case 't':
            trace_file = optarg;
            break;
        case 'v':
            verbosity = 1;
            break;
        case 'h':
            printUsage(argv);
            exit(0);
        default:
            printUsage(argv);
            exit(1);
        }
    }

    /* Make sure that all required command line args were specified */
    if (s == 0 || E == 0 || b == 0 || trace_file == NULL) {
        printf("%s: Missing required command line argument\n", argv[0]);
        printUsage(argv);
        exit(1);
    }

    /* Compute S, E and B from command line args */
    S = 1 << s;
    B = 1 << b;

    /* Initialize cache */
    initCache();

#ifdef DEBUG_ON
    printf("DEBUG: S:%u E:%u B:%u trace:%s\n", S, E, B, trace_file);
    printf("DEBUG: set_index_mask: %llu\n", set_index_mask);
#endif

	/* Read the trace and access the cache */
    replayTrace(trace_file);

    /* Free allocated memory */
    freeCache();

    /* Output the hit and miss statistics for the autograder */
    printSummary(hit_count, miss_count, eviction_count);
    return 0;
}
