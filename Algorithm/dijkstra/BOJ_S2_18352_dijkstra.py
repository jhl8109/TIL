import sys
import heapq

N,M,K,X = map(int,sys.stdin.readline().split())
answers = []
graph = {i:[] for i in range(1,N+1)}
for i in range(M):
    start,end = map(int,sys.stdin.readline().split())
    graph[start].append(end)

def dijkstra(X):
    heap = []
    costs = {}
    heapq.heappush(heap,(0,X))
    costs[X] = 0

    while heap:
        cost, cur_node = heapq.heappop(heap)
        if cur_node not in costs:
            costs[cur_node] = cost
            if cost == K:
                answers.append(cur_node)
        for next_node in graph[cur_node]:
            if next_node not in costs:
                heapq.heappush(heap,(cost+1,next_node))
    return costs

costs = dijkstra(X)

if len(answers) == 0:
    print(-1)

for answer in answers:
    print(answer)