class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = Counter(tasks) # count task frequencies
        
        maxHeap = [-cnt for cnt in count.values()] # use negate to simulate max heap
        heapq.heapify(maxHeap) # convert into heap

        time = 0 # CPU cycles counter
        # Use a queue to track tasks in cool down (remaining_count, ready_time)        
        cooldown_queue = deque()
        
        while maxHeap or cooldown_queue:
            time += 1 # every iteration is 1 CPU cycle

            if maxHeap: # if there are tasks ready to execute
                current_task = heapq.heappop(maxHeap) + 1 # process task (-1 count)
                if current_task < 0: # if tasks still remain, put it in cool down
                    cooldown_queue.append((current_task, time + n))

            # if tasks have cooled down, reinsert into heap
            if cooldown_queue and cooldown_queue[0][1] == time:
                heapq.heappush(maxHeap, cooldown_queue.popleft()[0])
        return time