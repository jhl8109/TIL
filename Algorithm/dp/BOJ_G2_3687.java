import java.io.*;
import java.util.*;

class BOJ_G2_3687{
	public static int n;
	public static int[] arr = {6,2,5,5,4,5,6,3,7,6};
	/*
	max / 2:1, 3:7, 4:11, 5:71, 6:111, 7:711, 8:1111 ...
	min / 2:1, 3:7, 4:4, 5:2, 6:6, 7:8, 
		  8:10, 9:18, 10:22, 11:20, 12:28, 13:68, 14:88, 
		  15: 108, 16:188, 17:200, 18:208, 19:288, 20:688, 21:888
		  22: 
	 */ // 8,15,
	public static String makeMax(int num){
		StringBuilder max = new StringBuilder();
		if(num%2 == 0) {
			max.append("1");
			num -= 1;
		} else {
			max.append("7");
			num -= 2;
		}
		for(int i=0; i<num/2; i++) {
			max.append("1");
		}
		return max.toString();
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		String[] add = {"0", "0", "1", "7", "4", "2", "0", "8"};
		long[] minDp = new long[101];
		Arrays.fill(minDp, Long.MAX_VALUE);
		minDp[2] = 1;
		minDp[3] = 7;
		minDp[4] = 4;
		minDp[5] = 2;
		minDp[6] = 6;
		minDp[7] = 8;
		minDp[8] = 10;
		for(int i=9; i<= 100; i++){
			for(int j=2; j<=7; j++) {
				String candidate = ""+minDp[i-j] + add[j];
				minDp[i] = Math.min(Long.parseLong(candidate), minDp[i]);
			}
		}
		for(int i=0; i<n; i++) {
			int target = Integer.parseInt(br.readLine());
			String max = makeMax(target);
			long min = minDp[target];
			bw.write(min + " " + max + "\n");
		}
		bw.flush();

		bw.close();
		br.close();
	}
}