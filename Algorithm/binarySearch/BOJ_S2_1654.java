import java.io.*;
import java.util.*;

public class BOJ_S2_1654 {
    private static int K,N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        long max = -1;
        for(int i=0; i<K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(arr[i],max);
        }
        max++;
        long min = 0;
        long mid = 0;


        while(min < max) {
            mid = (max + min)/2;

            long count = 0;

            for(int i=0;i<arr.length; i++) {
                count += (arr[i]/mid);
            }

            if(count < N) { // 길이를 더 줄여서 선 갯수를 늘림
                max = mid;
            } else { // N과 count가 같더라도 그 위쪽을 찾도록 함. ex) 198인 경우 -> 199 ~ max로 찾게 함.
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}