N = int(input())

memo = [-1] * (N+1)
memo[1] = 0

def dp(x):
    for i in range(2,x+1):
        tmp = []
        if i % 3 == 0:
            tmp.append(memo[i//3] + 1)
        if i % 2 == 0:
            tmp.append(memo[i//2] + 1)
        tmp.append(memo[i-1] + 1)
        memo[i] = min(tmp)
    return memo[x]

answer = dp(N)
print(answer)