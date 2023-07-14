import sys
from collections import deque

N, t = map(int, input().split())
targets = list(map(int,sys.stdin.readline().split()))
dq = deque([i for i in range(1,N+1)])
count = 0
for num in targets:
    while True:
        if dq[0] == num:
            dq.popleft()
            break
        else:
            if dq.index(num) <= len(dq) // 2:
                dq.rotate(-1)
                count += 1
            else:
                dq.rotate(1)
                count += 1
print(count)
