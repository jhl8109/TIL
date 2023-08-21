import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        if(sticker.length==1) return sticker[0];

        int[] dp = new int[sticker.length];
        
        for(int i=0; i<sticker.length; i++)
            dp[i]=0;
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        dp[sticker.length-1] = sticker[0];
        for(int i=2; i<sticker.length-1; i++) {
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);            
        }
        int firstMax = dp[dp.length-2];
        // System.out.println(Arrays.toString(dp));
        for(int i=0; i<sticker.length; i++)
            dp[i]=0;
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i=2; i<sticker.length; i++) {
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);            
        }
        int secondMax = dp[dp.length-1];
        // System.out.println(Arrays.toString(dp));
        return Math.max(firstMax,secondMax);
    }
}