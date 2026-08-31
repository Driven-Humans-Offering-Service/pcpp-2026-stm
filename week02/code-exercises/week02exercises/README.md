# Week 2

## Exercise 2.1
### 2.1.1
See file 'Monitor.java' in 'main/java/excises02'
### 2.1.2
yes the solution is fair towards writers. This is the case since whenever 
a writer wants to write, it prevents new readers from starting to read.
This then ensures at one point the readers will stop reading,
and the writer gets to write.
### 2.1.3
Technically yes, because 'synchronized' use one condition variable behind the scenes. 
All of the methods use them.
### 2.1.4 (Challenging)
Yes if there is assumed infinite time.
This is because eventually all new reads will wait for the waiting 
### 2.1.5 (Challenging)

## Exercise 2.2
### 2.2.1
Yes its possible for it to hang forever, this is the case because the running
variable is stored in a cashe/register that is not possible 
for the other thread to see the value change. 
### 2.2.2
_see 'MutableInteger.java'_
It prevents the thread from running forever since when using the synchronized keyword the 
JVM knows that the resource is shared between threads. This in turn fixes the memory visibility problem.
### 2.2.3
No, the program would hang. Because we havent told the JVM that this is a section that is impacted by other
sections, the JVM is free to optimize and keep the values in non shared memory,
preventing t from seeing the update
### 2.2.4
Yes, the program always terminates. This is because 'volitile' makes so that 'value' is in shared memory. 
This means when we edit it from one thread, we will always be able to see the value in the other thread, since
it's accessed from the shared memory every time.
## Exercise 2.3
### 2.3.1
Yes
### 2.3.2
The race condition appears since the static methods have a lock on the object Mystery.Class,
and the non static method addInstance has a lock on Mystery m, which means they
use two different locks, to guard the same variable.
### 2.3.3
To prevent editing the function modifiers, we can use the 'synchronized' block with the 'Mystery.class' 
to share the same lock in both the static and non-static methods. 
### 2.3.4
No since we call sum() after the two threads are joined, we are guaranteed that the intrinsic lock has been unlocked
and thus flushed to shared memory.










