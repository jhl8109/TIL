import sys
input = sys.stdin.readline

N = int(input())
values = [0]
for _ in range(N):
    values.append(int(input()))
answer = set()

def dfs(index, first, second):
    first.add(index)
    second.add(values[index])
    if values[index] in first: # 이전에 방문한 적 있는 지 확인
        if first == second:
            answer.update(first) # 정답 집합에 추가하기
        return
    return dfs(values[index], first, second) # 두번째 줄 숫자를 타고 넘어감

for i in range(1, N+1):
    if i not in answer:
        dfs(i, set(), set()) # i에서 집합이 될 수 있는 것들 찾기

print(len(answer))
for num in sorted(list(answer)):
    print(num)