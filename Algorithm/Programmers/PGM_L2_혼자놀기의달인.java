class PGM_L2_혼자놀기의달인 {
    // 1. 임의의 상자를 하나 선택함 숫자카드 확인 ... 1번 그룹(이미 열려있을 때 스톱)
    // 2. 1번 그룹을 제외하고 남는 상자가 없으면 점수 0
    // 3. 다시 임의의 상자 하나를 골라 같은 방식으로 구함. 2번 그룹
    // 4. 1번 그롭 * 2번 그룹
    // 무조건 그룹이 지어진다고 생각함.. 왜냐면 그룹이 안지어지면 애초에 같이 안골라짐..
    // 즉, 같은 그룹이면 1번 그룹이든 2번 그룹이든 한번에 묶였을것!
    // 결국 그룹이 몇개 나오는지, 가장 긴 그룹 두개의 곱을 구한다.
    private static int first=0, second=0;
    
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] isGrouped = new boolean[cards.length];
        for(int i=0; i<cards.length; i++) {
            if(isGrouped[i]) continue;
            int cnt = 1;
            int j = cards[i]-1;
            isGrouped[i] = true;
            while(!isGrouped[j]) {
                isGrouped[j] = true;
                j = cards[j]-1;
                cnt++;
            }
            if(cnt > first) {
                if(cnt > second) second = first;
                first = cnt;
            } else if(cnt > second) {
                second = cnt;
            }
        }
        // System.out.println(first + " , " + second);
        return first * second;
    }
}