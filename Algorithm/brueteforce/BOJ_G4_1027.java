import java.io.*;
import java.util.*;

class BOJ_G4_1027{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) {
            int left = i-1, right = i+1;
            double leftSlope = Integer.MAX_VALUE, rightSlope = Integer.MAX_VALUE;
            int count = 0, leftCount = 0, rightCount = 0;
            while(left >= 0 || right < N) {
                if(right < N) {
                    double slope = (double)(arr[i]-arr[right])/(right-i);
                    if(slope < rightSlope) { // 좋은 기울기
                        rightSlope = slope;
                        rightCount++;
                    } 
                    right++;
                }
                if(left >= 0) {
                    double slope = (double)(arr[i] - arr[left])/(i-left);
                    if(slope < leftSlope) {
                        leftSlope = slope;
                        leftCount++;
                    } 
                    left--;
                }
            }
            count = leftCount + rightCount;
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}