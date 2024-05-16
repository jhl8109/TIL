import java.io.*;
import java.util.*;

public class BOJ_G5_25444 {
    private static long n,k;

    // 가로 세로 순서와 상관 없어 보임.
    // 가로 세로 횟수와 상관 있는 듯함.
    // 자르는 횟수는 n회 고정이므로 가로 자르는 수를 x로 두면 세로 자르는 수는 n-x
    // 이를 통해 (x+1) * (n-x+1) = K가 되도록 구해야함.


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
        long min = 0;
        long mid = 0;
        long max = n/2;
        String answer = "NO";
        while(min <= max) {
            mid = (max+min)/2;

            long count = (mid+1) * (n-mid+1);
            if(count == k) {
                answer = "YES";
                break;
            } else if(count > k) {
                max = mid-1;
            } else { // count < k
                min = mid+1;
            }
        }

        System.out.println(answer);
    }
}