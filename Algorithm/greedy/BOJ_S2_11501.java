import java.util.*;
import java.io.*;

class BOJ_S2_11501{
    public static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = arr[N-1];
            long cost = 0;
            for(int j=N-2; j>=0; j--) {
                if(arr[j] > max) {
                    max = arr[j];
                } else {
                    cost += max - arr[j];
                }
            }
            // System.out.println(cost);
            bw.write(cost + "\n");
        }
        bw.flush();
        bw.close();
        br.close();


    }
}