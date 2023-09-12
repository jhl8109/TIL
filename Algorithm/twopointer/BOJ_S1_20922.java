import java.util.*;
import java.io.*;

public class BOJ_S1_20922 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = Arrays.stream(br.readLine().split(" "))
						.mapToInt(Integer::parseInt)
						.toArray();

		HashMap<Integer, Integer> hMap = new HashMap<>();
		int lt = 0, rt = 0, max = 0;						
		int size = 0;
		while(rt < N) {
			int value = hMap.getOrDefault(arr[rt],0);
			hMap.put(arr[rt],++value);
			size++;
			while (hMap.get(arr[rt]) > K) {
				// System.out.println(lt+" "+ rt);
				int tmp = hMap.get(arr[lt]);
				hMap.put(arr[lt], --tmp);
				lt++;
				size--;
			}
			max = Math.max(size,max);
			rt++;
		}
		System.out.println(max);
	}

}