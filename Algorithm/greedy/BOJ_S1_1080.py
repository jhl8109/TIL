from sys import stdin

def change(i, j):
    for x in range(i, i+3):
        for y in range(j, j+3):
            a[x][y] = 1 - a[x][y]

input = stdin.readline

n, m = map(int, input().split())
cnt = 0
flag = False
a = [list(map(int, input().strip())) for i in range(n)]
b = [list(map(int, input().strip())) for i in range(n)]

for i in range(n-2):
    for j in range(m-2):
        if a[i][j] != b[i][j]:
            change(i, j)
            cnt += 1

for i in range(n):
    for j in range(m):
        if a[i][j] != b[i][j]:
            flag = True

if flag:
    print(-1)
else:
    print(cnt)