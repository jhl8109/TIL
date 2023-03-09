
def check():
    result = 1
    for i in range(N):
        cnt = 1
        for j in range(1,N):
            if arr[i][j] == arr[i][j-1]:
                cnt+=1
            else:
                cnt = 1
            if result < cnt:
                result = cnt
        cnt = 1
        for j in range(1,N):
            if arr[j][i] == arr[j-1][i]:
                cnt+=1
            else:
                cnt = 1
            if result < cnt:
                result = cnt
    return result

N = int(input())
arr = [list(input().strip()) for _ in range(N)]
max = 0
for i in range(N): # y 좌표 이동
    for j in range(N): # x 좌표 이동
        if j+1 < N:
            tmp = arr[i][j]
            arr[i][j] = arr[i][j+1]
            arr[i][j+1] = tmp
            result = check()
            if max < result:
                max = result
            arr[i][j+1] = arr[i][j]
            arr[i][j] = tmp
        if i+1 < N:
            tmp = arr[i][j]
            arr[i][j] = arr[i+1][j]
            arr[i+1][j] = tmp
            result = check()
            if max < result:
                max = result
            arr[i+1][j] = arr[i][j]
            arr[i][j] = tmp
print(max)