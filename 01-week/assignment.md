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
