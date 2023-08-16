import sys
import copy

T = int(input())

# 45 : (n+1)/2 , 90 : 
def mainCross(board,tempBoard,n):
    for i in range(1,n+1):
        tempBoard[i][(n+1)//2] = board[i][i]
    # print('mainCross')
    # printBoard(tempBoard,n)
    
def centerColumn(board,tempBoard,n):
    for i in range(1,n+1):
        tempBoard[i][n-i+1] = board[i][n//2+1]
    # print('centerColumn')
    # printBoard(tempBoard,n)

def subCross(board,tempBoard,n):
    for i in range(1,n+1):
        tempBoard[(n+1)//2][i] = board[n-i+1][i]
    # print('subCross')
    # printBoard(tempBoard,n)

def centerRow(board,tempBoard,n):
    for i in range(1,n+1):
        tempBoard[i][i] = board[n//2+1][i]
    # print('centerRow')
    # printBoard(tempBoard,n)

def solve(board,n,d):
    times = 0
    if d >= 0:
        times = d // 45
    else:
        times = 8 - (-d) // 45
    for i in range(times):
        tempBoard = copy.deepcopy(board)
        mainCross(board,tempBoard,n)
        centerColumn(board,tempBoard,n)
        subCross(board,tempBoard,n)
        centerRow(board,tempBoard,n)
        board = tempBoard
    return board

def printBoard(board,n):
    for i in range(1, n+1):
        for j in range(1,n+1):
            print(board[i][j], end=' ')
        print()

for _ in range(T):
    n,d = map(int, sys.stdin.readline().split())
    board = [[0] * (n+1)]
    for _ in range(n):
        tmp = list(map(int,sys.stdin.readline().split()))
        tmp = [0] + tmp
        board.append(tmp)
    board = solve(board,n,d)
    printBoard(board,n)

