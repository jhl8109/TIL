from itertools import combinations

data = list(input())

stack = []
index = []
result = set() # ((2)) 같은 경우 중복 문자열 발생. 중복 제거
for i in range(len(data)):
    if data[i] == '(':
        stack.append(i)
    elif data[i] == ')':
        index.append((stack.pop(),i))

for i in range(1, len(index)+1):
    com = list(combinations(index, i)) # 조합 사용해서 제거할 괄호 쌍 뽑아내기
    for c in com:
        temp = data[:] # 문자열 복사
        for x,y in c:
            temp[x] = '' # 해당 인덱스 값(즉, 제거할 괄호) 공백 처리
            temp[y] = ''
        result.add(''.join(temp)) # 괄호 제거한 문자열들을 result에 집어 넣음  

result = list(result) # set 형태에선 sort를 쓸 수 없어서 list로 바꿔줌
result.sort()
for i in result:
    print(i)