import sys

N,M = map(int, input().split())
T = []
waiting = [] * (N)
for _ in range(N):
    tmp = int(sys.stdin.readline())
    T.append(tmp)

left, right = 0, max(T)*M
while left <= right:
    mid = (left+right)// 2

    people = 0
    for time in T:
        people += mid // time
    if people < M:
        left = mid + 1
    else:
        right = mid - 1
        answer = mid
print(answer)

    
