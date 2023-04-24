N,M = map(int,input().split())
r,c,d = map(int,input().split())

board = []
visited = [[0] * M for _ in range(N)]
dy = [-1,0,1,0]
dx = [0,1,0,-1]
answer = 0
for i in range(N):
    line = list(map(int,input().split()))
    board.append(line)

def solution(cur_r,cur_c,see):
    check = False
    if board[cur_r][cur_c] == 0 and not visited[cur_r][cur_c]:
        visited[cur_r][cur_c] = 1
        global answer
        answer += 1
    for _ in range(4):
        see = (see+3) % 4
        ny = cur_r + dy[see]
        nx = cur_c + dx[see]
        if ny >= 0 and ny < N and nx >=0 and nx < M and board[ny][nx] == 0 and visited[ny][nx] == 0:
            solution(ny,nx,see)
            check = True
            break
    if not check:
        ny = cur_r - dy[see]
        nx = cur_c - dx[see]
        if board[ny][nx] == 1:
            return
        else:
            solution(ny,nx,see)
            

            
solution(r,c,d)
print(answer)
# print(N,M,r,c,d)

# for i in range(N):
#     print(visited[i])