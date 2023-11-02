import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      int[] arr = new int[N+1];
      st = new StringTokenizer(br.readLine());
      for(int i=1; i<=N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      for(int i=0; i<K; i++) {
        st = new StringTokenizer(br.readLine());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        double answer = 0;
        for(int j=left; j<=right; j++) {
          answer += arr[j];
        }
        answer /= (right-left+1);
        System.out.printf("%.2f\n",answer);
      }
    }
}
