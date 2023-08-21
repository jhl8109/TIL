import java.util.*;

class Product{
	int w;
	int v;
	Product(int w, int v){
		this.w = w;
		this.v = v;
	}
}

class Main {
	public int solution(int N, int K, Product[] arr){
		int[][] dp = new int[N+1][K+1];

		for(int i=1; i<=N; i++) { // 물건
			for(int j=1; j<=K; j++) { // 무게
				// i번째 무게를 더 담을 수 없는 경우 
				if(arr[i].w > j) {
					dp[i][j] = dp[i - 1][j];
				}
				// i번째 무게를 더 담을 수 있는 경우 
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i].w] + arr[i].v);
				}
			}
		}
		return dp[N][K];
	}
	public static void main(String[] args){
		Main main = new Main();
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int K = kb.nextInt();
		Product[] arr = new Product[N+1];
		arr[0] = new Product(0,0);
		for(int i=1; i<=N; i++){
			int W = kb.nextInt();
			int V = kb.nextInt();
			arr[i] = new Product(W,V);
		}
		System.out.println(main.solution(N,K,arr));
	}
}