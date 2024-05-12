def solution(n, words):
    # n : 사람수, words : 단어 리스트
    answer = []
    target = 0
    cnt = set()
    prev = words[0][0]
    for i,word in enumerate(words, start=1):
        first = word[0][0]
        last = prev[-1]
        cur = len(cnt)
        cnt.add(word)
        tmp = len(cnt)
        print(i,word, cur,tmp,first,last)
        if cur == tmp or first != last: #중복 or 연결 안됨
            target = i
            break
        prev = word
    print(target)
    
    if target == 0:
        return [0,0]
    if target % n == 0:
        answer.append(n)
        answer.append(target//n)
    else:
        answer.append(target%n)
        answer.append(target//n + 1)
    
    return answer