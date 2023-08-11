import sys

sys.setrecursionlimit(10**6)

N = int(input())

memo = {}
memo[1] = 0

def dfs(x):
    if x not in memo.keys():
        tmp = []
        if x % 3 == 0:
            tmp.append(dfs(x//3) + 1)
        if x % 2 == 0:
            tmp.append(dfs(x//2) + 1)
        tmp.append(dfs(x-1) + 1)
        memo[x] = min(tmp)
    return memo[x]
    
answer = dfs(N)
print(answer)