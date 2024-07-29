## Cache Policies

### Quick Overview
- Goal: Simulate 3 different cache eviction policies (FIFO, LRU, and Clock) in a linked-list implementation of a fully associative cache
- Programming Language: Java
- Data Structures: Linked List
- Return hits and misses, and maintain count of compulsory and capacity misses

### What is a Cache?

### FIFO
1. If cache is empty, insert the element
2. If element is not in the cache, and the size of cache has not been reached, append new value
3. If element is not in the cache, and the size of cache has been reached, delete the first element and append the new element

### LRU
1. If cache is empty, insert the element
2. If element is not in the cache, and the size of cache has not been reached, append new value
3. If element is already in the cache, and the size of cache has not been reached, then move the first element to the back
4. If element is not in the cache, and the size of cache has been reached, delete the first element and append the new element

### Clock
1. If cache is empty, insert the element
2. If element is already in the cache, then set its reference bit
3. If element is not in the cache and the size of cache has been reached, continually unset the reference bit and move the clock pointer until the reference bit is no longer 1. Then, overwrite element at the clock pointer and move clock pointer again
4. If element is not in the cache and the size of cache has not been reached, append element to cache

### MRU
1. If cache is empty, insert the element
2. If element is not in the cache, and the size of the cache has not been reached, append new value
3. If element is already in the cache, and the size of cache has not been reached, then move the first occurrence of the element to the back
4. If element is not in the cache, and the size of cache has been reached, delete the last element and append the new element
