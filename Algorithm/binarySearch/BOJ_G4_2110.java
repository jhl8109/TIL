import java.io.*;
import java.util.*;

class BOJ_G4_2110{
	public static int N,C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[] homes = new int[N];
		for (int i=0; i<N; i++) {
			homes[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(homes);
		int result = 0;
		int left = 0;
		int right = homes[N-1]-homes[0];
		while(left<= right) { //공유기 설치의 최솟값을 대상으로 파라메트릭 서치
			int cnt=1;
			int beforePos = homes[0];

			int mid = (right+left)/2;
			for(int i=0; i<N; i++) {
				if(homes[i]-beforePos >= mid) {
					cnt++;
					beforePos = homes[i];
				}
			}
			if (cnt >= C) { //충분히 공유기 설치했을때
				result = mid;
				left = mid + 1; //최대 거리를 더 넓혔을 때 가능한 경우를 찾아봄
			} else {
				right = mid - 1;
			}
		}
		System.out.println(result);

	}
}