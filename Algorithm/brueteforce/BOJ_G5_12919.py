str1 = str(input())
str2 = str(input())

def cond1(target):
    return target[0:-1]

def cond2(target):
    reversed_str = "".join(reversed(target))
    return reversed_str[0:-1]

def solve(tmp):
    if len(tmp) == len(str1):
        if tmp != str1:
            return 0
        else:
            return 1
    if len(tmp) > len(str1):
        if tmp[-1] == 'A' and tmp[0] == 'A': # AA AB BA BB
            return solve(cond1(tmp))
        elif tmp[-1] == 'A' and tmp[0] == 'B':
            ans1 = solve(cond1(tmp))
            ans2 = solve(cond2(tmp))
            if ans1 > ans2:
                return ans1
            else:
                return ans2
        elif tmp[-1] == 'B' and tmp[0] == 'B':
            return solve(cond2(tmp))
        else:
            return 0 

check = solve(str2)
print(check)


