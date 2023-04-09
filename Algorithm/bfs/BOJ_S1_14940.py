from collections import deque

n,m = map(int, input().split())
board =[]
answer = [[-1] * m for _ in range(n)]
visited =[[False] * m for _ in range(n)]
dx = [0,0,-1,1]
dy = [-1,1,0,0]

queue = deque()

start = (10000,10000)
for i in range(n):
    inp = list(map(int,input().split()))

    if start == (10000,10000) and 2 in inp:
        for j in range(m):
            if inp[j] == 2:
                start = (i,j)

    board.append(inp)

def bfs(y,x):
    board[y][x] = 0
    visited[y][x] = True
    queue.append((y,x,0))
    while queue:
        (cur_y,cur_x,cur_dist) = queue.popleft()
        for i in range(4):
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                continue
            if visited[ny][nx] or board[ny][nx] == 0:
                continue
            queue.append((ny,nx,cur_dist+1))
            answer[ny][nx] = cur_dist+1
            visited[ny][nx] = True

bfs(start[0],start[1])

for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            print(0, end=' ')
        else:
            print(answer[i][j], end=' ')
    print()