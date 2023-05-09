from collections import deque

N,M,T = map(int, input().split())
board = []
visited = [[0] * M for _ in range(N)]
dy = [-1,1,0,0]
dx = [0,0,-1,1]

for _ in range(N):
    tmp = list(map(int,input().split()))
    board.append(tmp)

def solve(start,end,visited):
    gram_dist = 0
    ans = 10001
    queue = deque([start])
    visited[start[1]][start[2]] = 1
    while len(queue) != 0:
        cur = queue.popleft()
        if cur[1] == end[1] and cur[2] == end[2]:
            ans = min(ans,cur[0])
        for i in range(4):
            ny = dy[i] + cur[1]
            nx = dx[i] + cur[2]
            if ny < N and ny >= 0 and nx < M and nx >= 0 and visited[ny][nx] == 0:
                if board[ny][nx] == 0:
                    queue.append((cur[0] + 1, ny,nx))
                    visited[ny][nx] = 1
                if board[ny][nx] == 2:
                    queue.append((cur[0] + 1, ny,nx))
                    gram_dist = cur[0] + 1 + abs(ny-end[1]) + abs(nx-end[2])
                    ans = min(gram_dist,ans)
                    visited[ny][nx] = 1
    return ans

ret = solve((0,0,0),(T,N-1,M-1),visited)
if ret <= T:
    print(ret)
else:
    print("Fail")
