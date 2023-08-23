import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int i=0; i<=r2; i++) {
            int smallY = (int) Math.sqrt((long)r1*r1 - (long)i*i);
            int bigY = (int) Math.sqrt((long)r2*r2 - (long)i*i);
            int tmp = bigY-smallY;
            answer += tmp;
            if(i<r1 && Math.sqrt((long)r1*r1-(long)i*i)%1 ==0) answer++;
        }
        
        return answer * 4;
    }
}