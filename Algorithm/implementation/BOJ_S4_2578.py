import sys

SIZE = 5
board = []
for _ in range(SIZE):
    tmp = list(map(int,sys.stdin.readline().split()))
    board.append(tmp)

def delete_number(board, target):
    for i in range(SIZE):
        for j in range(SIZE):
            if board[i][j] == target:
                board[i][j] = 0
                return

def check_bingo(board):
    bingo = 0
    # 좌상우하 대각선
    check = 1
    for i in range(SIZE):
        if board[i][i] != 0: # 하나라도 삭제되지 않으면 한줄 빙고가 아님
            check -= 1
            break
    bingo += check
    # 우상좌하 대각선
    check = 1
    for i in range(SIZE):
        if board[i][4-i] != 0:
            check -= 1
            break
    bingo += check
    # 행
    check = 5
    for i in range(SIZE):
        for j in range(SIZE):
            if board[i][j] != 0:
                check -= 1
                break
    bingo += check
    # 열
    check = 5
    for i in range(SIZE):
        for j in range(SIZE):
            if board[j][i] != 0:
                check -= 1
                break
    bingo += check
    # print(bingo)
    if bingo >= 3:
        return True
    else:
        return False

answer = []
for i in range(SIZE):
    answer += list(map(int, sys.stdin.readline().split()))
    for j in range(SIZE):
        delete_number(board, answer[i*5 + j])
        if check_bingo(board):
            print(i*5 + j + 1)
            exit()
    

        

