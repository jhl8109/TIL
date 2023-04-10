import sys

N = int(input())

answer = []
arr = list(map(str,sys.stdin.readline().split()))


def t(left, pos, tmp,visited):
    visited[left] = True
    if arr[pos] == '<': cmp = True
    else: cmp = False    
    for i in range(0,10):
        if cmp and left < i and not visited[i]:
            if pos + 1 == N: 
                answer.append(tmp+str(i))
            else:
                t(i,pos+1,tmp+str(i), visited)
                visited[i] = False
        elif not cmp and left > i and not visited[i]:
            if pos + 1 == N: 
                answer.append(tmp+str(i))
            else:
                t(i,pos+1,tmp+str(i),visited)
                visited[i] = False
for i in range(0,10):
    visited = [False] * 10
    t(i,0,str(i),visited)
print(max(answer))
print(min(answer))
