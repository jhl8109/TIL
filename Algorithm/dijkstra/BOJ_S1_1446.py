import sys

N, D = map(int,sys.stdin.readline().split())
visited = [False] * N
ways = []
dp = [i for i in range(D+1)] 
for _ in range(N):
    start, end,dist = map(int, sys.stdin.readline().split())
    if end <= D and start >= 0 and end-start > dist:
        ways.append((start,end, dist))
ways.sort() # 시작 순으로 정렬하여 앞에 지름 길 탄 거에 영향을 받을 수 있도록 함.
def updateDP(end):
    for i in range(1, D-end+1):
        if dp[end + i] > dp[end] + i:
            dp[end + i] = dp[end]+i

def dijkstra():
    for i in range(len(ways)):
        if not visited[i]: # 정렬 한 순서대로 해서 앞에 것 부터 dp 수행
            visited[i] = True
            start, end, dist = ways[i][0], ways[i][1], ways[i][2]
            if dp[end] > dist+ dp[start]:  # 거리가 줄어들 경우 지름길을 탐
                dp[end] = dist + dp[start]
                updateDP(end) # 그 지름길 이후 거리 업데이트

dijkstra()
print(dp[D])    