from heapq import heappush, heappop
import sys
N = int(input())
heap = []
for _ in range(N):
    tmp = int(sys.stdin.readline())
    if tmp == 0:
        if len(heap) == 0: #아무 것도 없으면 0출력
            print(0)
        else:
            first = heap[0] # 절댓값을 확인하기 위한 제일 앞 요소
            i,heads = 0,[] 
            while i < len(heap):
                if heap[i][0] == first[0]: 
                    heads.append(heap[i]) #절댓값이 가장 작은 값이 여러개 
                    i += 1
                else: break
            print("heap : ", heap)
            print("heads : " , heads)
            realFirst = min(heads,key = lambda x:x[1]) #여러 개중 실제 값이 가장 작은 것을 출력
            print(realFirst[1])
            heap.remove(realFirst)        
    else:
        heappush(heap,(abs(tmp),tmp))
