import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets,(o1,o2)-> {
            return o1[1]-o2[1]; 
        });
        int last = 0;
        for(int i=0;i<targets.length;i++) {
            int start = targets[i][0];
            int end = targets[i][1];
            if(start < last) {
                continue;
            } else {
                last = end;
                answer++;
            }
        }
        
        return answer;
    }
}