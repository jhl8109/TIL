import java.util.*;
import java.io.*;

class BOJ_G4_2631{
    public static int N,answer;
    public static int[] arr, dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for(int i=0; i<N; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        answer = N-Arrays.stream(dp).max().getAsInt();
        System.out.println(answer);
        // System.out.println(Arrays.toString(dp));
    }
}