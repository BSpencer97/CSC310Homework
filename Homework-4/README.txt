-------------------------------------------Hw4Prob1.java-------------------------------------------

The Hw4Prob1.java file contains a circular queue class that is array-based. It contains
methods such as: MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not.
isFull(): Checks whether Deque is full or not. 

These can be tested by calling the methods in main. The insert methods require an integer input and
the MyCircularDequeue(k) requires an integer equal to the size you want the circular queue to be.

-------------------------------------------Hw4Prob2.java-------------------------------------------

The Hw4Prob3.java file contains a node class and linkedlist-based queue class. It contains the merge
method, which will merge two sorted lists into a single, combined list. To test this merge function,
create two linkedlist objects (LLCoolQueue) and put any number of elements (in ascending order).
Then, call the merge function using the front attribute of the objects as the parameters, but create
a new linkedlist object (LLCoolQueue) equal to that function call.

-------------------------------------------Hw4Prob3.java-------------------------------------------

The Hw4Prob3.java file contains a node class and linkedlist-based queue class. It contains the methods
(enqueue(object), enqueueKey(int t), dequeue(), first(), len(), is_empty(), search()). Enqueue can be
called by creating an queue node and passing it as a parameter, adding it to the already constructed
linkedlist object (LLCoolQueue). There is a non-object version of enqueue called enqueueKey, which 
takes an integer input and creates a new queue node with that value as the data, then adds it to the
queue. Search can be called by creating a queue node and passing it as a parameter, and returns true
if the data of that queue node is found in any of queue's current queue node's data. There is a 
non-object version of search called searchKey, which takes an integer input and sees if that value is
equal to any of the data of the queue nodes of the queue. The other methods are called without parameters.