from heapq import heappush, heappop
import sys

N = int(input())
heap = []
for _ in range(N):
    tmp = int(sys.stdin.readline())
    if tmp == 0:
        if len(heap) == 0: #아무 것도 없으면 0출력
            print(0)
        else:
            print(heappop(heap)[1])
    else:
        heappush(heap,(abs(tmp),tmp))
