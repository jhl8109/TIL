import sys

N,M = map(int,input().split())

graph= [[] for _ in range(N+1)]
for _ in range(M):
    A,B = map(int, sys.stdin.readline().split())
    graph[B].append(A)

def dfs(index, visited=set()):
    visited.add(index)
    count = len(graph[index])
    for i in range(len(graph[index])):
        if not i in visited:
            count += dfs(graph[index][i],visited)

    return count
answer = []
maxCnt = 0
for i in range(1,N+1):
    cnt = dfs(i)
    if cnt > maxCnt:
        maxCnt = cnt
        answer.clear()
        answer.append((i,cnt))
    elif cnt == maxCnt:
        answer.append((i,cnt))

answer.sort(key=lambda x:x[0])
for ans in answer:
    print(ans[0])


