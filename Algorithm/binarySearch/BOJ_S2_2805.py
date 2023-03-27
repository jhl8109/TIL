N,M = map(int, input().split())

arr = list(map(int, input().split()))
start = 0
end = max(arr)

result = 0
while start <= end:
    total = 0
    mid = (end + start)//2
    for x in arr:
        if x > mid:
            total += x - mid
        if total > M:
            break
    if total < M:
        end = mid - 1
    else:
        result = mid
        start = mid + 1
print(result)