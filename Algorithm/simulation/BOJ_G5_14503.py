N,M = map(int,input().split())
r,c,d = map(int,input().split())

board = []
visited = [[False] * M for _ in range(N)]
dy = [-1,0,1,0]
dx = [0,1,0,-1]
answer = 0
for i in range(N):
    line = list(map(int,input().split()))
    board.append(line)

def solution(cur_r,cur_c,see):
   
    while True:
        check = False
        if board[cur_r][cur_c] == 0 and not visited[cur_r][cur_c]:
            visited[cur_r][cur_c] = True
            global answer
            answer += 1
        for i in range(4):
            if see == 0:
                see = 3
            else:
                see -= 1
            ny = cur_r + dy[see]
            nx = cur_c + dx[see]
            if ny >= 0 and ny < N and nx >=0 and nx < M and board[ny][nx] == 0 and not visited[ny][nx]:
                # print(ny,nx,1)
                solution(ny,nx,see)
                
                check = True
        if not check:
            new_see = 0
            if see <= 1:
                new_see = see + 2
            else:
                new_see = see - 2
            ny = cur_r + dy[new_see]
            nx = cur_c + dx[new_see]
            if ny >= 0 and ny < N and nx >=0 and nx < M and board[ny][nx] == 0 and not visited[ny][nx]:
                # print(ny,nx,2)
                solution(ny,nx,see)
                
            else:
                break
            

            
solution(r,c,d)
print(answer)
print(N,M,r,c,d)
for i in range(N):
    print(board[i])
for i in range(N):
    print(visited[i])