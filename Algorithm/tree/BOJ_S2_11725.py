import sys

sys.setrecursionlimit(10**7)

N = int(input())
graph = list()
answer = [0] * (N+1)
answer[1] = 1
for i in range(N-1):
    (a,b) = map(int, input().split())
    graph.append((a,b))
# 1이랑 연결되어있으면 depth 그다음부터 치고 나가야함.
def dfs(parent, graph):
    for (a,b) in graph:
        if answer[a] != 0 and answer[b] != 0:
            continue
        if a == parent and answer[b] == 0:
            answer[b] = parent
            dfs(b,graph)
        elif b == parent and answer[a] == 0:
            answer[a] = parent
            dfs(a,graph)


dfs(1,graph)
for i in range(2,N+1):
    print(answer[i])
