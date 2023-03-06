def hansu(n) :
    count = 0
    for i in range(1,n+1):
        if i < 100: # 한자리 또는 두자리
            count += 1
        else : # 세자리
            i1 = int(i % 10)
            i2 = int(i / 10  % 10)
            i3 = int(i / 100)
            if i2 - i1 == i3 - i2 :
                count += 1
    return count

# main
N = int(input())
result = hansu(N)
print(result)

