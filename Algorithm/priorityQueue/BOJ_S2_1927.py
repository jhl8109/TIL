import heapq
import sys

inp = sys.stdin.readline
heap = []
N = int(input())

def solve(heap,answer = []):
    for i in range(N):
        k = int(inp()) 
        if k == 0: # 0일 때 : pop, 출력
            if len(heap) == 0:
                answer.append(0)
            else:
                answer.append(heapq.heappop(heap))
        else: #0이 아닐 때 : 추가
            heapq.heappush(heap,k)
    return answer

answer = solve(heap)

for ans in answer:
    print(ans)
