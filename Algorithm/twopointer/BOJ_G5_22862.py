N, K = map(int, input().split())
arr = list(map(int, input().split()))
save,even = 0,0
p1,p2,cnt = 0,0,0

# 시작점을 p1, 끝점을 p2
# tmp == K일 때 p1을 뒤로 옮김
# tmp != K일 때 p2를 뒤로 옮김
while p2 < len(arr):
    if cnt <= K: # 아직 K번 탐색 안했을 때 다음 것 탐색
        if arr[p2] % 2 != 0: #다음이 홀수 일때
            cnt += 1
        else:
            even += 1
        p2 += 1
        save = max(save,even)
    else: #cnt를 다 소비했을 때
        save = max(save,even)
        if arr[p1] % 2 != 0: #앞 포인터를 땡겼을 때 홀수면
            cnt -= 1
        else:
            even -= 1
        p1 += 1
    # print(p1,p2,even,cnt)
print(save)

