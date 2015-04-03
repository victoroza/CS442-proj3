CS442 Design Patterns
Spring 2015
PROJECT 3 README FILE

Due Date: Friday, April 3, 2015
Submission Date: Friday, April 3, 2015
Author(s): Victor Oza
e-mail(s): voza1@binghamton.edu


PURPOSE: To build a simple task manager using the observer pattern

PERCENT COMPLETE: 100%

PARTS THAT ARE NOT COMPLETE: N/A

BUGS: No known bugs.

FILES: File description is given in assignment

SAMPLE OUTPUT:

run:
     [java] FileProcessor constructor called
     [java] FileProcessor constructor called
     [java] DashBoardSubject constructor called
     [java] PerformanceTab constructor called
     [java] UsersTab constructor called
     [java] ProcessesTab constructor called
     [java] PerformanceTabFilterImpl constructor called
     [java] UsersTabFilterImpl constructor called
     [java] ProcessesTabFilterImpl constructor called


EXTRA CREDIT: N/A



## To clean:
ant -buildfile src/build.xml clean

## To compile: 
ant -buildfile src/build.xml all

## To run
ant -buildfile src/build.xml run <args>
ant -buildfile src/build.xml -Darg0="new_in1.txt" -Darg1="out.txt" -Darg2="2" run


## To create tarball for submission
ant -buildfile src/build.xml tarzip