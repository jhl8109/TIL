import math

N = int(input())
M = int(input())
board = [[0] * N for _ in range(N)]
answer = []
def snail(size,board,row,column):
    value = size**2
    dy = [1,0,-1,0]
    dx = [0,1,0,-1]
    global answer;
    board[row][column] = value
    if value == M:
        answer.append(row+1)
        answer.append(column+1)
    for i in range(4):
        for j in range(size-1):
            value -= 1 
            row += dy[i]
            column += dx[i]
            if i == 3 and j == size-2:
                snail(size-2,board, row+1,column+1)
                return
            if value == M:
                answer.append(row+1)
                answer.append(column+1)
            board[row][column] = value     

snail(N,board, 0, 0)

def print_board(board):
    for i in range(N):
        for j in range(N):
            print(board[i][j], end=' ')
        print()

print_board(board)
print(answer[0],end=' ')
print(answer[1])