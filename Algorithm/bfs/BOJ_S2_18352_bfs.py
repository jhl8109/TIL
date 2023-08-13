import sys
from collections import deque

N,M,K,X = map(int,sys.stdin.readline().split())

graph = {i:[] for i in range(1,N+1)}
for i in range(M):
    start,end = map(int,sys.stdin.readline().split())
    graph[start].append(end)

def bfs(X):
    q = deque()
    visited = [False for _ in range(N+1)]
    costs = {i:0 for i in range(1,N+1)}
    q.append((0,X))
    visited[X] = True

    while q:
        cost,cur_node = q.popleft()
        costs[cur_node] = cost
        for next_node in graph[cur_node]:
            if not visited[next_node]:
                q.append((cost+1,next_node))
                visited[next_node] = True
    return costs
costs = bfs(X)

answer = []
for key,value in costs.items():
    if value == K:
        answer.append(key)

if len(answer) == 0:
    print(-1)
else:
    for ans in answer:
        print(ans)



