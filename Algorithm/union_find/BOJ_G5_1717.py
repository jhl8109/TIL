import sys
sys.setrecursionlimit(100000)
n, m = map(int,input().split())
parent = [i for i in range(n+1)]
answer = []

def union(a,b):
    root_a = find(a)
    root_b = find(b)
    if root_a < root_b:
        parent[b] = a
    else:
        parent[a] = b

def find(x):
    if parent[x] != x: #루트 노드가 아니라면
        parent[x] = find(parent[x]) #루트 노드를 리턴
    return parent[x]

for i in range(m):
    cmd, a, b = map(int, sys.stdin.readline().split())
    if cmd == 0:
        union(a,b)
    else: #cmd == 1
        if find(a) == find(b):
            answer.append("YES")
        else:
            answer.append("NO")
print(parent)
for ans in answer:
    print(ans)