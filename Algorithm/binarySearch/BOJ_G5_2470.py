N = int(input())

arr = list(map(int, input().split()))
arr.sort()

result = 10000000000
start = 0
end = N-1 # len(arr) -1
ans = [0,0]
while start < end:
    tmp = arr[start] + arr[end]
    if abs(tmp) < result:
        result = abs(tmp)
        ans = [start,end]
        if result == 0:
            break
    if tmp > 0:
        end = end -1 
    elif tmp < 0: 
        start = start + 1 
print(arr[ans[0]], arr[ans[1]])