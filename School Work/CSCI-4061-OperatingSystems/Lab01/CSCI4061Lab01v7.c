//CSCI4061 Lab1 by Nathan Comer and Eric Bjorgan

#define _GNU_SOURCE
#include <sched.h>
#include <errno.h>
#define STACKSIZE (1024*1024)
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>

static int childFuction();
int needsExecuteBackground();
char* args[10];
pid_t pid;
int BUILT_IN_FLAG = 0;
int (*builtIn)();
int clone_flg;
char child_stack[STACKSIZE];

struct clone_args {
        char **argv;
};

int timerPrint(){
			
			int isNumber = 1;
	    		for(int m = 0; m < strlen(args[1]); m++){
				if(args[1][m] < '0' || args[1][m] > '9'){
					isNumber = 0;
					break;
				}
	   		}
			if(!isNumber){
				fprintf(stderr, "timerPrint usage: timerPrint <seconds> <String To Print>\n");
				return -1;
			}else{
				int value = (int) strtol(args[1], (char **)NULL, 10);
               			sleep(value);
				int n = 2;
				while (args[n] != NULL){
					if(strcmp(args[n],"&") != 0){
						fprintf(stderr, "%s ", args[n]);
					}
					n++;
				}
				fprintf(stderr,"\n");

            }
		return 0;
}

int main(){
	
        char* input = (char*)malloc(200*sizeof(char));
	const char* delims = "  ";
        int j,i=0;
    	int status;
	

        while(1){
	    BUILT_IN_FLAG = 0;
	    start:
	    i = 0;
	    for(int n = 0; n < sizeof(*args); n++){
	           args[n] = '\0';
	    }
            fprintf(stderr, "$ "); //print beginning of command line 
            fgets(input, 200, stdin);  // reads in from command line
            input[strlen(input) - 1] = '\0'; // adds null character to end of string read in from command line
                char * tok = (char *) malloc(100); // initialize tok        
                tok = strtok(input, delims); // takes the first word
                args[i] = tok; // places elements in args one at a time
		if (args[0]==NULL) {
			goto start;
		}

        while(args[i] != NULL){
              i++;
              args[i] = strtok(NULL, delims);
        }
             

	for (j = 0; j < i; j++){
		//fprintf(stderr, "Argument #%d is '%s'\n", j, args[j]);
		args[j][strlen(args[j])] = '\0'; // adds null character to end of the token
	}


            //fprintf(stderr, "Args stripped\n");


        //Start processing

	int runBackground=0;    

            if (strcmp(args[0],"timerPrint") == 0) { // Compares strings
		BUILT_IN_FLAG = 1;
		builtIn = timerPrint;
		needsExecuteBackground(); 
	    }
            else if (strcmp(args[0], "quit") == 0){
                    exit(0);
	    }
	    else if (strcmp(args[0], "Clone") == 0){
		clone_flg=0;		
		int n = 1;
		
		if (args[1] == NULL){
			fprintf(stderr, "Command Clone needs at least one argument\n");

		}

		while (args[n] != NULL)	{	

		
			if (strcmp(args[n], "CLONE_NEWIPC") == 0){		
			clone_flg = clone_flg | CLONE_NEWIPC;
			//newClone(args[0], args[1]);		
			}
			else if (strcmp(args[n], "CLONE_NEWUTS") == 0){
			clone_flg = clone_flg | CLONE_NEWUTS;
			//newClone(args[0], args[1]);		
			}
			else if (strcmp(args[n], "CLONE_NEWUSER") == 0){
			clone_flg = clone_flg | CLONE_NEWUSER;
			//newClone(args[0], args[1]);
			}
			else if (strcmp(args[n], "CLONE_NEWNS") == 0){
			clone_flg = clone_flg | CLONE_NEWNS;
			//newClone(args[0], args[1]);
			}
			else if (strcmp(args[n], "CLONE_NEWNET") == 0) {
			clone_flg = clone_flg | CLONE_NEWNET;
			//newClone(args[0], *args[1]);
			}
			n++;
		}
		newClone(args[0], args[1]);
	    }	
            else {
		if (strcmp(args[i-1], "&") == 0){
			args[i-1] = '\0';
			needsExecuteBackground();
		}else{
	      		needsExecute();   
		}
            }
	}
	return 0;
}

int needsExecute(){
		pid = fork();		    
		if (pid < 0){
			fprintf(stderr,	"Fork failed\n");
			exit(-1);
		}else if (pid == 0) { //Child
			//fprintf(stderr, "Fork successful\n");
			//fprintf(stderr, "Argument #%d is '%s'\n", 0, args[0]);
				char *cmd[strlen(args)];
				*cmd = args[0];
				if(execvp(*cmd,args) == -1){
					fprintf(stderr, "Command not found\n");	
				}
			exit(0);
                 }
		  wait(&pid);
	return 0;	 
}

int needsExecuteBackground(){
		pid = fork();		    
		   if (pid < 0){
			fprintf(stderr,	"Fork failed \n");
			exit(-1);
		   }else if (pid == 0) { //Child
			fprintf(stderr, "\n");
			//fprintf(stderr, "Fork successful\n");
			//fprintf(stderr, "Argument #%d is '%s'\n", 0, args[0]);
				char *cmd[strlen(args)];
				*cmd = args[0];
				if(BUILT_IN_FLAG){
					builtIn();
				} else if(execvp(*cmd,args) == -1){
					fprintf(stderr, "Command not found\n");	
				}	
			exit(0);
                   } return -1;   
}


static int childFunction(void *stuff)
{
	printf("\n");
	//printf("New `net` Namespace: \n");
  	//system("ifconfig");
	//system("ip link");
  	printf("\n\n");
	//fprintf(stderr, "Entering new sh\n");	
	system("sh");
        struct clone_args *args2 = (struct clone_args *)stuff;
        if (execvp(args2->argv[0], args2->argv) != 0) {
                fprintf(stderr, "failed to execvp argments %s\n",
                        strerror(errno));
                return(-1);
        }
        return(EXIT_FAILURE);
}

int newClone(int argc, char **argv)
{
        struct clone_args args2;
        args2.argv = &argv[1];
	//printf("Old `net` Namespace:\n");	
	//system("ifconfig");
	//system("ip link");

	int clone_flags = CLONE_NEWPID | clone_flg | SIGCHLD;
	
        pid_t pid = clone(childFunction, child_stack + STACKSIZE, clone_flags, &args2);
	//fprintf(stderr, "\nnewClone PID is: %d\n", pid);
        if (pid < 0) {
                fprintf(stderr, "Create new clone failed: %s\n", strerror(errno));
                exit(EXIT_FAILURE);
        }
	//waitpid(pid, NULL, 0);
        if (waitpid(pid, NULL, 0) == -1) {
                fprintf(stderr, "failed to wait pid %d\n", pid);
                return(EXIT_FAILURE);
        }
        return(EXIT_SUCCESS);
}

