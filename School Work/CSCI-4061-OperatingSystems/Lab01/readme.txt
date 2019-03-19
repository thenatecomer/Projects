Eric Bjorgan (ejb@umn.edu)
Nathan Comer (comer028@umn.edu)

CSCI 4061 - Fall 2016
Mark Langanki

C Command Shell

All parts of the shell are completed and should work correctly.

Built In commands:
	
	timerPrint <int> <&args>
	 	timerPrint runs in the background and after a specified amount of time it prints the remaining argument(s).
	
	Clone <&args>
		Clone can be called with any of the following arguments in any order:
			CLONE_NEWIPC	- New namespace for IPC
			CLONE_NEWUTS	- Setup new hostname and domain
			CLONE_NEWUSER	- User and group changes
			CLONE_NEWNET	- New network namespace
			CLONE_NEWNS 	- New mount namespace

	quit
		exits out of the shell

Executable commands can be run just like other Linux shells.

Background commands:
	Commands can be run in the background by appending & at the end of the command line.

