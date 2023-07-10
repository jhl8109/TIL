MAX = 250
n = int(input())

def square(n):
    answer = 4
    for i in range(MAX,0,-1):
        if i**2 == n:
            return 1
        elif i**2 < n:
            for j in range(i,0,-1):
                if i**2 + j**2 == n:
                    return 2
                elif i**2 + j**2 < n:
                    for k in range(j,0,-1):
                        if i**2 + j**2 + k**2 == n:
                            answer = min(answer, 3)
    return answer

print(square(n))