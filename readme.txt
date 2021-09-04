/******************************************************************************
 *  readme.txt template                                                   
 *****************************************************************************/

Name: Zackary McClamma
Date: 27 July 2020
Hours to complete assignment (optional): approx 12 hrs (I attempted various
different solutions after implementing the MinHeap but was unable to get
any other solution to work properly, the solution that I was able to get working
only took me around 1-2 hours)

/******************************************************************************
 *  Explain how to compile/run your program.
 *****************************************************************************/
To run this program open the project in eclipse, in the toolbar at the top select
the 'Run' tab and under that menu select 'Run Configurations...', in the window
that pops up there is a tab called 'Arguments' select that tab and in the program
arguments box put the path to the text file containing the graph information (I 
put mine in the root directory so I just had to input the name of the text file)



/******************************************************************************
 *  Explain how you improved the algorithm.
 *****************************************************************************/
I "improved" the algorithm by utilizing the 3-Way heap from assignment 1 to replace
the Java standard library PriorityQueue in the standard algorithm. I made an attempt
at a few of the other reccommended methods (processing from source and destination and
removing vertices with only two adjacent nodes) but I was not able to get those methods
to work.






/******************************************************************************
 *  What is the order of growth of the amount of memory (in the worst
 *  case) of your program as a function of V and E?
 *
 *  Briefly justify your answer.
 *****************************************************************************/
The order of growth for the amout of memory for this program is O(V + E) becuase
the program utilzes a weighted graph the values for the usa.txt file are as follows

Number of vertices =  87575
Number of edges    =  121961

Amount of memory = 209536 words


/******************************************************************************
 *  What is the order of growth of the running time (in the worst case)
 *  of your program as a function of V and E?
 *
 *  Briefly justify your answer.
 *****************************************************************************/
The while loop for the Dijkstra algorithim has a run time of O(V + E), and the 
minHeap insert function has a runtime of O(log V) so the overall runtime of the 
altorithm is O(E+V) * O(log V) which is equal to O(E log V)



/******************************************************************************
 *  Known bugs / limitations / challenges.
 *****************************************************************************/
One of the issues I have found with this algorithm is that for longer paths
(generally paths longer than about 10 hops) the 3-Way heap is not more efficent
than the standard algorithm. I think this may be due to some ineffeciencies in
the resizing the heap when a value is removed. I also attempted to implement two
of the other reccomended optimizations with no success. I wasn't able to find a
good way to keep track of the removed nodes when I attempted to remove nodes
with only two neighbors. I also tried to implement a search that started from both
the source and destination but was unable to get the correct path out of my
implementation, due to this I ended up sticking with the simple approach of using
the 3-way heap.




/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
I enjoyed this project though I would have like to been able to implement something
other than the 3-way heap implementation. It was fun trying to optimize an algorithm
that is already incredibley efficent. I found attempting to make Dijkstra faster is no
simple task.  
