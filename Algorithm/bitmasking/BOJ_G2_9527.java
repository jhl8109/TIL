import java.io.*;
import java.util.*;

class BOJ_G2_9527{
	public static long A,B;
	static long[] dp = new long[55];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());

		setDP();
		long result = calOne(B) - calOne(A-1);
		System.out.println(result);
	}
	public static long calOne(long num){
		long count = num&1;
		//비트마스킹을 이용한 1의 개수 계산 진행
        //DP[i-1] : 000 ~ 111 개수
        //N - (1L << i) : 지정된 1이 반복 사용될 개수 
        // + 1 : 1000... 
		for (int i=54; i>0; i--){
			if((num & (1L << i)) > 0L) { // num의 i번째 비트가 1이면
				count += dp[i - 1] + (num - (1L << i) + 1);
				num -= (1L << i);
			}
		}
		return count;
	}

	public static void setDP(){
		dp[0] = 1;
		//점화식 적용
        //DP[i-1] << 1 : DP[n-1] × 2
        //1L << i : 2ⁿ
		for(int i=1; i<55; i++){
			dp[i] = dp[i-1]*2 + (1L << i);
		}
	}
}