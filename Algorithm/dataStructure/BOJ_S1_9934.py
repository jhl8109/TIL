K = int(input())
buildings = list(map(int, input().split()))
tree = [[] for _ in range(K)]

def make_tree(buildings,height):
    
    mid = len(buildings) // 2
    tree[height].append(buildings[mid])
    if len(buildings) == 1:
        return
    make_tree(buildings[:mid],height+1)
    make_tree(buildings[mid+1:],height+1)

make_tree(buildings,0)

for i in range(K):
    for num in tree[i]:
        print(num, end=' ')
    print()