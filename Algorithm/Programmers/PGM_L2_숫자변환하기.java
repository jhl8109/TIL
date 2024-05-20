import java.util.*;

public class PGM_L2_숫자변환하기 {
    
    public static int answer = Integer.MAX_VALUE;
    public static Map<Integer,Integer> map = new HashMap();
 
    public int solution(int x, int y, int n) {
        int[][] dp = new int[3][1000001];
        for(int i=0; i<3; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][x] = 0;
        dp[1][x] = 0;
        dp[2][x] = 0;
        for(int i=x+1; i<=y; i++) {
            for(int j=0; j<3; j++) {
                if(i-n >= 0 && dp[j][i-n] != Integer.MAX_VALUE) {
                    dp[0][i] = Math.min(dp[0][i],dp[j][i-n]+1);
                }
                
                if(i%2 == 0 && dp[j][i/2] != Integer.MAX_VALUE) {
                    dp[1][i] = Math.min(dp[1][i],dp[j][i/2]+1);
                }
                
                if(i%3 == 0 && dp[j][i/3] != Integer.MAX_VALUE) {
                    dp[2][i] = Math.min(dp[2][i],dp[j][i/3]+1);
                }
            }
        }
        for(int i=0; i<3; i++) {
            answer = Math.min(answer,dp[i][y]);
        }
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
}
