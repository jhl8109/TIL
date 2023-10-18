import java.io.*;
import java.util.*;

class Main{
    static int N,M;
    static int[] parents;
    static int[] trip;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N];
        for(int i=0; i<N; i++) {
            parents[i] = i;
        }

        trip = new int[M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) union(i,j);
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            trip[i] = Integer.parseInt(st.nextToken())-1;
        }
        boolean flag = true;

        for(int i=1; i<M; i++) {
            if(parents[trip[i]] != parents[trip[i-1]]) flag = false;
        }

        System.out.println(flag ? "YES" : "NO");
    }
    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot < bRoot) parents[bRoot] = aRoot;
        else if(aRoot > bRoot) parents[aRoot] = bRoot;
    }
    static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
}