import sys

V,E = map(int,input().split())
graph = []
parent = [i for i in range(V+1)]

for i in range(1,E+1):
    start,end,weight = map(int, sys.stdin.readline().split())
    graph.append((start,end,weight))

graph.sort(key = lambda x:x[2])

def union(a,b):
    a = find(a)
    b = find(b)
    if a < b: 
        parent[b] = a
    else: 
        parent[a] = b

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

cnt = 0
answer = 0
for i in range(E):#V-1번 실행
    a,b,weight = graph[i][0], graph[i][1], graph[i][2]
    if find(a) != find(b):
        union(a,b)
        answer += weight
        cnt += 1
    if cnt == V-1:
        break

print(answer)