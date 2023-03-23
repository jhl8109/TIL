N = int(input())

x,y = map(int, input().split())

M = int(input())
board = [[] for _ in range(N+1)]
visited = [False] * (N+1)
result = []
for i in range(M):
    parent, child = map(int, input().split())
    board[parent].append(child)
    board[child].append(parent)

def dfs(cur, dist,board):
    visited[cur] = True
    for next in board[cur]:
        if next == y:
            result.append(dist+1)
        else:
            if not visited[next]:
                dfs(next,dist+1,board)
                 
    
dfs(x,0,board)
if len(result) == 0:
    print(-1)
else:
    print(result[0])





