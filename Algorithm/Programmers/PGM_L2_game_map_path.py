from collections import deque

def solution(maps):
    q = deque()
    n = len(maps)
    m = len(maps[0])
    dx = [1,-1,0,0] # 동서 남북
    dy = [0,0,1,-1]
    def bfs(y,x):
        maps[y][x] = 0
        q.append((y,x,1))
        while q:
            cur = q.popleft()
            for i in range(4):
                ny = cur[0] + dy[i]
                nx = cur[1] + dx[i]
                dist = cur[2] + 1
                if nx > m-1 or ny > n-1 or nx < 0 or ny < 0:
                    continue
                if maps[ny][nx] == 1:
                    if ny == n-1 and nx == m-1:
                        return dist
                    q.append((ny,nx,dist)) 
                    maps[ny][nx] = 0
                    
        return -1
                   
    dist = bfs(0,0)
    return dist