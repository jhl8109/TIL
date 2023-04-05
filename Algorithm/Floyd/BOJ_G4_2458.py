import sys

INF = int(1e9)

N, M = map(int, sys.stdin.readline().split())

graph = [[INF]*(N+1) for _ in range(N+1)] #INF: 기록X, 0: 나보다 작음, 1: 나보다 큼

for _ in range(M):
    a,b = map(int, sys.stdin.readline().split())
    graph[a][b] = 0
    graph[b][a] = 1

def floyd_warshall():
    for num in range(1,N+1):
        for i in range(1,N+1):
            for j in range(1,N+1): # 00 01 10 11 
                if graph[i][j] != INF: continue
                if graph[i][num] == 0 and graph[num][j] == 0: graph[i][j] = 0
                elif graph[i][num] == 1 and graph[num][j] == 1: graph[i][j] = 1

def canIknow():
    count = N
    for i in range(1,N+1):
        for j in range(1,N+1):
            if i == j: continue
            if graph[i][j] == INF:
                count -= 1
                break

    return count

floyd_warshall()
answer = canIknow()
print(answer)

