import java.util.*;

public class PGM_L3_인사고과 {
    // nlogn -> 이분탐색 아니면, 정렬?
    public int solution(int[][] scores) {
        int answer = -1;
        int[] target = scores[0];
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[0]+b[1], a[0]+a[1]);
                // if(a[0] == b[0]) return Integer.compare(a[1],b[1]);
                // return Integer.compare(a[0],b[0]);
            }
        });
        int cnt = 0;
        int same = 0;
        int prev = Integer.MAX_VALUE;
        for(int i=0; i<scores.length; i++) {
            boolean check = false;
            for(int j=i-1; j>=0; j--) {
                if(scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
                    check = true;
                    break;
                }
            }
            if(!check) {//점수 와라
                int sum = scores[i][0]+scores[i][1];
                if(prev == sum) {
                    same++;
                } else {
                    cnt += same+1;
                    same=0;
                    prev = sum;
                }
                
            }
            // System.out.println(scores[i][0] + " , " + scores[i][1] + " : " + cnt);
            if(scores[i] == target) {
                if(!check) {
                    return cnt;
                }
                else return -1;
            }
            
        }

        return answer;
}