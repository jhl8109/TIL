import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

N,M = map(int, input().split())
graph = list([] for _ in range(N+1))
visited = [False] * (N + 1)

for i in range(M):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(start):
    visited[start] = True
    
    for i in graph[start]:
        if visited[i] == False:
            visited[i] = True
            dfs(i)

count = 0
for i in range(1,N+1):
    if visited[i] == False:
        dfs(i)
        count+=1
print(count)