import sys

N, M = map(int,input().split())

points = list(map(int,input().split()))

def binary_search(points, line):
    left = 0
    right = len(points) - 1

    left_most = -1
    right_most = -1
    # line 좌측 점보다 크면서, 가장 작은 거 찾기
    while left <= right:
        mid = (left + right) // 2
        
        if points[mid] < line[0]:
            left = mid + 1
        else:
            right = mid - 1

    left_most = left
    
    left = 0
    right = len(points) - 1
    # line 우측 점보다 작으면서, 가장 큰거 찾기
    while left <= right:
        mid = (left + right) // 2
        
        if points[mid] > line[1]:
            right = mid - 1
        else:
            left = mid + 1
    right_most = left
    return right_most - left_most
lines = []
answers = []
points.sort()
for i in range(M):
    start,end = map(int, sys.stdin.readline().split())
    answer = binary_search(points, (start,end))
    answers.append(answer)

for answer in answers:
    print(answer)



