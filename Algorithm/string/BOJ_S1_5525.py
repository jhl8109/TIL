N = int(input())
M = int(input())
target = input()
check = ""
check_length = 2 * N + 1
for i in range(check_length):
    if i % 2 == 0: check += 'I'
    else: check += 'O'
        
answer = 0
count = 0
i = 0
# print (target[i:i+3])
while i < M - (check_length - 1):
    tmp = target[i:i+3]
    if tmp=='IOI':
        i+=2
        count += 1
        if count == N:
            count -= 1
            answer += 1
    else:
        i += 1
        count = 0
        
print(answer)