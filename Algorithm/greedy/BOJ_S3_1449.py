N,L = map(int,input().split())
arr = list(map(int,input().split()))

arr.sort()

count = 1
tmp = arr[0]

for point in arr:
    if point <= tmp+L-1:
        continue
    else :
        tmp = point
        count += 1

print(count)