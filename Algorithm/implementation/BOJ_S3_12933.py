from collections import deque

target = list(input())
find_list = ['q','u','a','c','k']
visited = [False] * len(target)
ducks = [0] * len(target)
def solve(target,start):
    answer = 0
    q = deque()
    if target[start] == 'q':
        q.append((start,0))
    while q:
        start, quack_idx = q.popleft()
        for i in range(start,len(target)):
            if visited[i]: continue
            if i != 0 and target[i] == 'q':
                q.append((i,0))
            if target[i] == find_list[quack_idx]: # quack 순서대로 잘 이동 중
                quack_idx += 1
                visited[i] = True
                if quack_idx == 5: # quack가 완성
                    quack_idx = 0
                    update_ducks(ducks, (start,i))
                    # print(start,i,visited,q,ducks)
                    start = i+1
            if quack_idx == 5:
                return -1 
    if not all(visited):
        return -1 
    return max(ducks) 

def update_ducks(ducks, target):
    for i in range(target[0], target[1]+1):
        ducks[i] += 1
        

answer = solve(target[0:],0)
# print(ducks)
if answer == 0 or len(target) % 5 != 0:
    print(-1)
else:
    print(answer)

    
