

def solution(numbers, target):
    
    answer = 0
    
    def dfs(start,cur):
        node = numbers[start]
        new_cur1 = cur + node
        new_cur2 = cur - node
        if start == len(numbers) -1 and (new_cur1 == target or new_cur2 == target) :
            global answer
            answer +=  1
        else:
            if start + 1 == len(numbers): return
            dfs(start + 1, new_cur1)
            dfs(start + 1, new_cur2)
        
    dfs(0,0)
    
    return answer