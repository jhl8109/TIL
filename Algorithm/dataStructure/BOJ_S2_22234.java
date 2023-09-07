import java.util.*;
import java.io.*;

class BOJ_S2_22234{
    public static int N,M;
    public static TreeSet<String> set;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new TreeSet<>();
        for(int i=0; i<N; i++) {
            String tmp = br.readLine();
            set.add(tmp);
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            
            while(st.hasMoreTokens()) {
                String next = st.nextToken();
                if(set.contains(next)) set.remove(next);
                // System.out.println(next);
            }
            // System.out.println(set.size());
            bw.write(set.size() + "\n");
        }
        bw.flush();
    }
}