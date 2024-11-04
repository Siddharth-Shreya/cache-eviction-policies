## Cache Policies

Use the app: [https://cache-evictions-simulator.netlify.app/](https://cache-evictions-simulator.netlify.app/)

### Project Overview

##### Goal
Simulate 4 different cache eviction policies (FIFO, LRU, MRU and Clock) in a linked-list implementation of a fully associative cache.

##### Background
- What is a cache? A cache is a temporary, small storage space for data to be quickly accessed. It's usually used to store frequently used or important information to avoid taking a long time to obtain from longer-term memory.
- What does it mean to be "fully associative"? This means that data can be stored in **any** unused block in a cache.
  
##### Tools and Technologies
- Backend: Java, Spring Boot
- Frontend: React.js, JavaScript, CSS
- Deployment: Render (using a Dockerfile) for the backend and Netlify for the frontend
- Data Structures: Linked List

### Different policies
##### FIFO
1. If cache is empty, insert the element
2. If element is not in the cache, and the size of cache has not been reached, append new value
3. If element is not in the cache, and the size of cache has been reached, delete the first element and append the new element

##### LRU
1. If cache is empty, insert the element
2. If element is not in the cache, and the size of cache has not been reached, append new value
3. If element is already in the cache, and the size of cache has not been reached, then move the first element to the back
4. If element is not in the cache, and the size of cache has been reached, delete the first element and append the new element

##### Clock
1. If cache is empty, insert the element
2. If element is already in the cache, then set its reference bit
3. If element is not in the cache and the size of cache has been reached, continually unset the reference bit and move the clock pointer until the reference bit is no longer 1. Then, overwrite element at the clock pointer and move clock pointer again
4. If element is not in the cache and the size of cache has not been reached, append element to cache

##### MRU
1. If cache is empty, insert the element
2. If element is not in the cache, and the size of the cache has not been reached, append new value
3. If element is already in the cache, and the size of cache has not been reached, then move the first occurrence of the element to the back
4. If element is not in the cache, and the size of cache has been reached, delete the last element and append the new element
