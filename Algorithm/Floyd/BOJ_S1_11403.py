import sys

N = int(input())
graph = []
for _ in range(N):
    line = list(map(int,sys.stdin.readline().split()))
    graph.append(line)

for num in range(N): #N번 만큼 간선을 거쳐감
    for i in range(N):
        for j in range(N):
            if graph[i][num] and graph[num][j]:
                graph[i][j] = 1

for i in range(N):
    for j in range(N):
        print(graph[i][j], end=' ')
    print()