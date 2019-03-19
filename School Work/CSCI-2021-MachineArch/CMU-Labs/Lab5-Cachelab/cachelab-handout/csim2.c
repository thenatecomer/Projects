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
mem_addr_t set_index_mask;

/* 
 * initCache - Allocate memory, write 0's for valid and tag and MRU
 * also computes the set_index_mask
 */
void initCache()
{
	int setIndex;
	int lineIndex;

	cache_set_t set;
	cache_line_t line;
		
	S=pow(2,s);
	B=pow(2,b);

	cache = (cache_set_t*) malloc(8*S); // 8 byte memory address

	for (setIndex = 0; setIndex < S; setIndex++){
        	
        	set =  (cache_line_t*) malloc(sizeof(cache_line_t)*E);
        	cache[setIndex] = set;

        	for (lineIndex = 0; lineIndex < E; lineIndex ++){
            		line.valid = 0;
            		line.tag = 0; 
            		set[lineIndex] = line;    
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
	int lineIndex;
	int prev_hits = hit_count;
	int tag_size = (64 - (s + b));
	int cache_full = 1;  

	unsigned long long temp = addr << (tag_size);
	unsigned long long setIndex = temp >> (tag_size + b);

	mem_addr_t input_tag = addr >> (s + b);

	cache_set_t input_set = cache[setIndex];

	for (lineIndex = 0; lineIndex < E; lineIndex++) {
		cache_line_t line = input_set[lineIndex];

		if (line.valid == 1){
			if (line.tag == input_tag){
			hit_count++;
			input_set[lineIndex] = line;
			}
		} else if (cache_full) {
			cache_full = 0;
		}
	}

	
	
	if (prev_hits == hit_count) { // hit_count wasn't incremented so it missed
		miss_count++;
	} else {
		 // exit function
	}

	int mru_Index = 0;
	int mru_Value = -1;

	
	//finds the  line index of most recently used line or empty line if one exists
	for (int lineTemp = 0; lineTemp < E; lineTemp++) { 
		if (input_set[lineTemp].mru > mru_Value){
			mru_Index = lineTemp;
			mru_Value = input_set[lineTemp].mru;
		}
	}

	if (cache_full) {
		eviction_count++;
		
		//All empty lines will have an mru value of 0
		//thus the for loop above will choose an empty line if one exists

		input_set[mru_Index].tag = input_tag;
		input_set[mru_Index].mru = mru_counter;
		mru_counter++;
	}
	
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
        sscanf(buf+3, "%llx,%u", &addr, &len);
	switch(buf[2]){
		case 'I':
		break;
		case 'L':
			accessData(addr);
		break;
		case 'S':
			accessData(addr);
		break;
		case 'M':
			accessData(addr);
			accessData(addr);
		break;
		default:
		break;
	}



	/* buf[Y] gives the Yth byte in the trace line */

        /* Read address and length from the trace using sscanf 
           E.g. sscanf(buf+3, "%llx,%u", &addr, &len);
         */

        /*  
         *    ACCESS THE CACHE, i.e. CALL accessData
		 *    Be careful to handle 'M' accesses	
         */
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
    //S =  ?
    //B =  ?
 
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
