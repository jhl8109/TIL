import sys

N = int(input())

target = str(input())
numbers = []
for _ in range(N):
    tmp = int(sys.stdin.readline())
    numbers.append(tmp)

def solve(N,target,numbers):
    stack = []
    target_idx, number_idx = 0,0
    answer = 0
    while target_idx < len(target):
        if target[target_idx].isalpha():
            number_idx = ord(target[target_idx]) - 65
            stack.append(numbers[number_idx])
        else:
            second = stack.pop()
            first = stack.pop()
            if target[target_idx] == '+':
                tmp = first + second
            if target[target_idx] == '-':
                tmp = first - second
            if target[target_idx] == '*':
                tmp = first * second
            if target[target_idx] == '/':
                tmp = first / second
            stack.append(tmp)
        target_idx += 1
    
    answer = stack[0]
    return answer
answer = solve(N,target, numbers)

print("{:.2f}".format(answer))