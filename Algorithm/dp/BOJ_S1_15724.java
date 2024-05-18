import java.io.*;
import java.util.*;

public class BOJ_S1_15724 {
    private static int N = 0, M = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] nation = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                nation[i][j] = nation[i-1][j] + nation[i][j-1] - nation[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        int times = Integer.parseInt(br.readLine());
        for(int i=0; i<times; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int answer = nation[y2][x2] - nation[y1-1][x2] - nation[y2][x1-1] + nation[y1-1][x1-1];

            System.out.println(answer);
        }
    }
}
