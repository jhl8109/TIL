import java.util.*;
import java.io.*;

class BOJ_G5_2467{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt =0, rt = N-1;
        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while(lt < rt) {
            int sum = arr[lt] + arr[rt];
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                ans[0] = arr[lt];
                ans[1] = arr[rt];
            }
            if(sum < 0) {
                lt++;
            } else {
                rt--;
            }
        }
        System.out.printf("%d %d\n",ans[0],ans[1]);
    }
}