def self_num() :
    tmp = []
    for num in range(1,10000):
        res = constructor(num)
        tmp.append(res)
    return tmp 

def constructor(num) :
    num1 = num % 10 # 첫번째 자리
    num2 = int(num / 10) % 10 # 두번째 자리
    num3 = int(num / 100) % 10 # 세번째 자리
    num4 = int(num / 1000) % 10 # 네번째 자리
    return num + num1 + num2 + num3 + num4

# main
self_num_list = []
result = self_num()
self_num_list.extend(result)
self_num_list.sort()

for i in range(1,10000) :
    if i not in self_num_list :
        print(i)