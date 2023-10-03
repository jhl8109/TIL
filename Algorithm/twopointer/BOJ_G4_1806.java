import java.io.*;
import java.util.*;

class BOJ_G4_1806{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));
		int lt=0, rt=0;
		int answer = Integer.MAX_VALUE;
		int sum=0;
		while(lt<=rt) {
			if (sum < S ) {
				if(rt >= N) break;
				sum += arr[rt++];
			} else { //sum >= S
				answer = Math.min(answer, rt-lt);
				sum -= arr[lt++];
			}		
		}
		if (answer == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(answer);
	}
}