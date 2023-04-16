import sys
N = int(input())

dy = [0,0,1,-1]
dx = [1,-1,0,0]
board = [[0] * (N+1) for _ in range(N+1)]

def printBoard(board):
    for i in range(N+1):
        print(board[i])

def find_max_near_empty(near_max,empty_max,near_board,empty_board):
    near_list, empty_list = [], []
    for i in reversed(range(1,N+1)):
        for j in reversed(range(1,N+1)):
            if board[i][j] != 0: continue
            if near_board[i][j] == near_max:
                near_list.append((i,j))
            if empty_board[i][j] == empty_max:
                empty_list.append((i,j))
    if len(near_list) > 1:
        big,ind = 0, ()
        for i in range(len(near_list)):
            a,b = near_list[i]
            if big <= empty_board[a][b]:
                big = empty_board[a][b]
                ind = (a,b)
        return ind    
    return near_list[0]

def countEmptyAll(near):
    near_board, empty_board = [[0] * (N+1) for _ in range(N+1)],[[0] * (N+1) for _ in range(N+1)]
    near_max, empty_max = 0,0
    for i in range(1,N+1):
        for j in range(1,N+1):
            if board[i][j] != 0: continue
            near_cnt, empty_cnt = 0,0
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if ny > 0 and ny < N+1 and nx > 0 and nx < N+1:
                    if board[ny][nx] in near:
                        near_cnt +=1
                    if board[ny][nx] == 0: # 근처에 없음
                        empty_cnt+=1
            near_board[i][j] = near_cnt
            empty_board[i][j] = empty_cnt
            if near_cnt >= near_max: near_max = near_cnt
            if empty_cnt >= empty_max: empty_max = empty_cnt
    return find_max_near_empty(near_max,empty_max,near_board,empty_board)


pref_list = []

for _ in range(N * N):
    line = list(map(int,sys.stdin.readline().split()))
    pref_list.append(line)
    man,pref = line[0], line[1:]
    a,b = countEmptyAll(pref)
    board[a][b] = man
    # print("=" * 20)
    # printBoard(board)
pref_list.append([0,0,0,0,0])
pref_list.sort()

def countScore(pref_list):
    score = 0
    for i in range(1,N+1):
        for j in range(1,N+1):
            value = board[i][j]
            near = pref_list[value][1:]
            near_cnt = 0
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if ny > 0 and ny < N+1 and nx > 0 and nx < N+1:
                    if board[ny][nx] in near:
                        near_cnt +=1
            score += int(10 ** (near_cnt - 1))
            # print(score)
    return score

score = countScore(pref_list)
print(score)

