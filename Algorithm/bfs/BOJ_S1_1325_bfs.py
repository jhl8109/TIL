import sys
from collections import deque

N,M = map(int,input().split())

graph= [[] for _ in range(N+1)]
for _ in range(M):
    A,B = map(int, sys.stdin.readline().split())
    graph[B].append(A)

def bfs(index):
    visited = [False] * (N+1)
    queue = deque()
    queue.append(index)
    visited[index] = True
    count = 1
    while queue:
        node = queue.popleft()
        for next_node in graph[node]:
            if visited[next_node] == False:
                visited[next_node] = True
                queue.append(next_node)
                count += 1
    return count

answers = []
maxCnt = 0
for i in range(1,N+1):
    cnt = bfs(i)
    if cnt > maxCnt:
        maxCnt = cnt
        answers.clear()
        answers.append((i,cnt))
    elif cnt == maxCnt:
        answers.append((i,cnt))
answers.sort(key=lambda x:x[0])
for node in answers:
    print(node[0])