N = int(input())
arr = list(map(int, input().split()))
stack = []
answer = [0] * N
for i in range(N):
    ans = 0
    while stack:
        if stack[-1][1] > arr[i]:
            ans = stack[-1][0] + 1
            break
        else:
            stack.pop()
    stack.append((i,arr[i]))
    answer[i] = ans
print(" ".join(map(str,answer)))