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


EXERCISE 1.2:
