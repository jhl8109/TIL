import java.util.*;
import java.io.*;

class BOJ_G4_1253{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));
		int answer = 0;
		for(int i=0; i<N;i++) {
			int left=0,right = N-1;
			while(left < right && right < N && left >= 0) {		
				if(left == i) {
					left++;
				} 
				if(right == i) {
					right--;
				}
				if(left == right) {
					break;
				}
				int sum = arr[left]+arr[right];
				if(sum > arr[i]) {
					right--;
				} else if(sum < arr[i]) {
					left++;
				} else {
					answer++;
					// System.out.printf("i : %d, arr[i] : %d, %d+%d\n", i, arr[i], arr[left], arr[right]);
					break;
				}
				
			}
		}
		System.out.println(answer);


	}
}