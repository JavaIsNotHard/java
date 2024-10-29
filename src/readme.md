Threads in java are managed by the OS that the JVM is running on 
which are called OS-level threads

OS-level threads are heavy then required and may require 1-2 MB of stack space

Virtual threads are different from platform threads and OS threads.
The OS threads are managed by the OS itself, the platform are abstraction of the OS thread used by the java platform which means that when you create a new thread using the `Thread thread = new Thread();` it creates a platform thread rather than a OS thread. 

The scheduling and context swtiching of the Platform thread is managed by the OS itself.

On the other hand a virtual thread is managed by the Java runtime or JVM. The virtual thread is itself created from a platform thread and is relatively lightweight in comparision to the platform thread. This means that a single OS thread or platform thread can create a number of virtual threads within them.

The JVM creates a number of platform thread ready for virtual threads to run during then runtime. The number of platform thread depends on the number of physical CPU cores that the  system consists of. 

When a new virtual thread is ready for execution, they are placed on a queue of waitiing ready virtual threads. Once the platform threads are free from their current operation then next virtual thread from the queue is brought into the platform thread for execution. 

When a virtual thread performs a long running task such as an I/O operation then they are placed on blocked thread list which bascially pauses the execution of the virtual thread and brings another virtual thread from the queue for execution. Meaning virtual threads have good concurrency support. 

When a virtual thread performs an I/O operation it does not block the actual OS thread or platform thread since the OS/platform thread are managing other virtual threads running in them.

Once a virtual thread has completed an I/O operation then they are placed on the ready thread queue waiting for execution from the platform thread.

**NOTE**: Different CPU cores will execute different threads either of the same process or different

JVM and how it manages threads and their execution
- We have discussed that based on the number of CPU cores in the system, the platform threads are created for virtual threads to run in. 
- A process has multiple line of execution i.e multiple threads running and each thread will run it a separate platform thread i.e OS thread.
- Each platform thread runs in separate CPU cores since each CPU cores have their own PC (program counter)
- Each virtual thread has its own stack and heap memory allocated to it for execution during its runtime. 
- The order of execution of thread is not guaranteed and depends on the CPU and the scheduling algorithm that is implemented in it.
- The stack space between threads of the same process are different for different threads but the heap portion for different threads are the same.
- Local variables are created in the thread specific stack whereas objects and references also created on the stack but the object they are referencing are created inside the heap portion which is visible by all the threads of the same process 

Now in the architecture level we have three layers of data transfer
we have CPU and the register at the highest level 
we have CPU caches below them 
and at the bottom we have the main memory
Data are transfer from main memory to the CPU cache and only then to the CPU registers
Each thread in the architecture level as mentioned previous will have their own stack space and a shared heap and run in a specific CPU core. Each CPU will have different registers in them.
The stack and the heap region of the thread is located in the main memory region of the computer. 
The fact that different threads of the same process runs in different CPU core brings the problem of race condition
Race condition happens when different threads both access a shared variable in an non-synchornized manner which results in inconsistent result at the end of the program execution.
Race condition can occur also when the CPU has builtin cache coherence and as well as due to timing issue to the thread execution. A thread can be paused in the middle of its execution and can start another thread
The problem of race condition can be removed by many methods such as locks, semaphores, condition variables, java has the synchronized and volative keywords for this problem


Field visibility and instruction order of execution

So what is field visibility?
When two threads are executing in different cores then there is a possibility that they run in parallel. 
When one thread writes a data back there is no guarantee that write is flushed back to the disk i.e it can be temporarily stored in the CPU cache or even in one of the registers 
This means if another thread is expecting the new value from the first thread it will not see the updated value but rather a stale value. 
This is the field visibility problem that the volatile keyword and synchronization block solves.

Instruction order of exeuction which is basically when compilers generate instructions in a way that utilizes the CPU better but 

The before-happens guarantee of the java memory model


The Synchronized keyword
the block of code inside the synchronized keyword can be executed one thread at a time .
When we declare an instance method synchronized means that only one thread can execute that method on a given instance of class i.e during the runtime of the instance of the class
we can either use the synchronized keyword in a code block or with a function 
The usage of this inside the synchronized keyword bracket means that they are synchronized on the same monitor object i.e this

The same behaviour can be observed when using static fields and methods. Two threads executing a static method that belongs to the same monitor class cannot execute at the same time

We can use anytime of object as monitor object unless it is a String object 
best practice is to use instance of your object or class of our object or the root Object object

The synchronized keyword solves the visibility problem of objects and also has the happens-before guarantee

The Volatile keyword
If you are developing a single threaded program then the use of volatile keyword for variables is not recommended because volatile keyword guarantees that all the variables 
are going to be written to the main memory and not in the registers and caches which means that if we do not have a visbility problem we can just write to the cache and registers rather 
than to the memory because writing to the main memory is more expensive than writing to cache or registers.

Cache coherence mechanism that makes sure that the shared value in the caches of a multi-core system are consistent meaning that if one core's thread were to change a shared data 
between two threads running in two different cores then when the first threads writes to the shared data to the cache or the main memory then that new value is also reflected in the second core's cache. 


ThreadLocal object in java 
used to store local variables for a thread that cannot be accessed or removed by another thread
when we add a value to a threadLocal from one thread then we cannot get that value from another thread 
when we remove a value of a threadLocal using threadLocal.remove() method that it does not remove the value set by another thread.

Concurrency vs parallelism 
- Concurrency -> One CPU decides the workload of multiple threads by context switching between them fast 
- Parallelism -> Dividing a process task into multiple threads and executing them at the same time in different CPUs
- Parallel Concurrent Execution ->  Multiple threads are executed in multiple CPUs through context switching
- Parallel Execution -> Multiple threads running in multiple CPUs

using locks inside try and finally statement
This is necessary because if the critical section we are protecting returns an exception then it would end the program 
but rather go inside the finally block unlock the lock, this makes sure that even if one thread throws an exception 
and exits other thread can still lock the lock after the previous thread unlocked it inside the finally block

Reentrant lockout in java locks
This allows the same thread from locking the same lock again. The thread that locks the lock can lock it any number of time
but it also needs to unlock the lcok the same number of times. If we didn't have a reentrant lock then it would result in 
a deadlock becuase if thread 1 acquires the lock and again the same thread comes back and tried to acquire the lock again
this makes the thread wait for the same thread to release the lock. How can one thread release a lock if it is waiting for 
itself to release the same lock.

reentrant locks and lock fairness between threads

lock.LockInterruptibly
Only allows the thread to lock a lock if it has not been interrupted

lock.tryLock()
tries to lock a lock and if not available then will return a boolean of true or false rather than being blocked 
for the lock

The Reentrant lock methods

java ExecutorService for ThreadPooling
ThreadPooling basically has 3 components, the blockingTaskQueue, the threads and a runnable insde the taskQueue
the blockingTaskQueue is a Queue data structure meaning that it works on the principle of FIFO, the queue removes 
one task from the queue and calls the thread to execute the task, the thread to execute can be any thread and there is 
no order of execution of threads.

executorservice.execute() vs .submit()
execute takes a runnable and does not return any Future
submit takes a callable which returns something called the Future object
the Future object holds the state of the task currently being executed by a thread. it contains state info such 
as isDone(), isCancelled and so on. we can also get the result
The future also holds the value returns by the callable and the value can be retrived using the future.get() method
submit also takes a runnable but since the runnable doesn't return result our future.get() method returns null

executorservice.invokeAny()
future.get() is a blocking operation because it blocks the thread that is executing the task until its corresponding task is not completed
cancelling of executor service
does the executorservice block the main thread until we call the executorservice.shutdown()
how is the Future object returned to the main thread 