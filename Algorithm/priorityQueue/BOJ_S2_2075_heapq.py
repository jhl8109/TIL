import sys
import heapq

# 제일 첫 줄이 가장 작음
# -> 가장 작은 것보다 작으면 거르기 ..

N = int(input())
heap = []

for i in range(N):
    numbers = list(map(int, sys.stdin.readline().split()))
    for number in numbers:
        if len(heap) < N:
            heapq.heappush(heap,number)
        else:
            if heap[0] < number:
                heapq.heappop(heap)
                heapq.heappush(heap,number)

print(heap[0])
    