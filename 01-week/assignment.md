EXERCISE 1.1:

Q1)
19793719

Q2)
It is not guaranteed, but the chance of a bad interleaving happening much smaller than before. This means that in cases where we have a small problem size (200), it is much less likely to happen.

Q3)
It is the same since behind the scenes they execute the same instructions.

Q4)
Our solution is correct since access to the critical section is blocked behind the lock using mutual exclusion.

Q5)
Yes it does since it only contains the one line that reads and writes.
We have not added to the get operation since this is only accesses after the threads are done, using the join statement, even tho one could argue that to be a thread safe class the method also needs to use the lock

Q6)
As seen in the codeblocks they decompile to the same bytecode instructions which means there is no difference between += and ++

```
 11: getfield      #22                 // Field count:J
   14         14: lconst_1
   13         15: ladd
   12         16: putfield      #22                 // Field count:J
```
```
11: getfield      #22                 // Field count:J
   14         14: lconst_1
   13         15: ladd
   12         16: putfield      #22                 // Field count:J  
```


Q7)
The expected output should be within [-10.000.000,10.000.000] but in a perfect world (with locks) it should be 0.

It is correct now since all the critical sections are guarded by a lock using mutual exclusion.

Q8)
The minimum count should be 3 since if we are very unlucky the threads will always read the same number and therefore do the same work. Yes the minimum number will always be equal to counts since if we are very unlucky the threads will end up doing the same work.

```
public void increment() {
            long temp = count;  //1
            count = temp + 1;   //2
        } 
```

In the case of counts = 3:
t1(1),t2(1),t1(2),t2(2),t1(1),t2(1),t1(2),t2(2),t1(1),t2(1),t1(2),t2(2)

this pattern can be expanded to any size :)

EXERCISE 1.2:

Q2)
```
public void print() {
            System.out.print("-"); //1
            try { Thread.sleep(50); } catch (InterruptedException exn) { } //2
            System.out.print("|"); //3
        }
```

..,t1(1), t2(1), t1(2), t2(2), t1(3), t2(3),..

Q3)
the critical section is now the printing of '-', the sleep and the printing of '|' and is locked using mutual exclusion. This ensures that each thread will do both prints ensuring nothing is printed inbetween.

Q4)
It is impossible to do this:
```
public void print() {
            System.out.print("-"); //1
            try { Thread.sleep(50); } catch (InterruptedException exn) { } //2
            System.out.print("|"); //3
        }
```
  -     -       |      -      |      -      |      -      |      |
t1(1), t2(1), t2(2), t2(1), t2(2), t2(1), t2(2), t2(1), t2(2), t1(2)

In the above interleaving it is seen that we can make the first half of the sequence no problem but since both threads only run four times, the pipe from thread 1 appears before it should.
This is also due to the fact that each thread has to run 4 times EACH. If it was shared work and they had to run 8 times in total the interleaving would be possible to recreate.

EXERCISE 1.3:
The critical section is guarded by a lock which ensures that the threads do not count the people entering wrongly and the check up against MAX_PEOPLE_COVID ensures that the thread will return whenever the limit is reached.

EXERCISE 1.4:
Q1)
Since the 3 categories from each reading material can be matched almost one-to-one it is almost impossible to come up with examples where they do not overlap. The following matching between the reading material's definitions can be done:

Convinence note - Goetz:
Exploitation - Fairness
Inherent - Resource Utilisation
Convinience - Hidden

Q2)
Exploitation:
- Ethereum miner
- Bachelor in matrix operations on the GPU
- Unreal engine

Inherent:
- Google maps app
- Computer games
- Web application

Hidden:
- Linux Kernel
- Google docs
- Gmail

Exercise 1.5:
Q1)
Linux

Q2)
Num of cores: 16
Caches (sum of all):
L1d:                       384 KiB (8 instances)
L1i:                       256 KiB (8 instances)
L2:                        8 MiB (8 instances)
L3:                        16 MiB (1 instance)
Amount of memory: 23Gb RAM and 8Gb VRAM

Q3)
1854ns

