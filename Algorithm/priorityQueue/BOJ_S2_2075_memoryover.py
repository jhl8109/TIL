import sys

# 제일 첫 줄이 가장 작음
# -> 가장 작은 것보다 작으면 거르기 ..

N = int(input())
board = [[0]*N for _ in range(N)]

for i in range(N):
    board[i] = list(map(int, sys.stdin.readline().split()))

print(board)

def solve(N):
    candidates = []
    for i in range(N):
        for j in range(N):
            candidates.append(board[i][j])
    candidates.sort()

    return candidates[N**2-N]

answer = solve(N)
print(answer)
    