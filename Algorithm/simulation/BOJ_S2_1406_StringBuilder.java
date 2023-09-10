import java.util.*;
import java.io.*;

class BOJ_S2_1406_StringBuilder{
    public static String input;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        input = br.readLine();
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(input);
        int cursor = input.length();
       
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            String add = "";
            if (st.hasMoreTokens())
                add = st.nextToken();
            
            switch(cmd) {
                case "L" :
                    if(cursor >= 1)
                        cursor--;
                    break;
                case "D" :
                    if(cursor <= sb.length()-1)
                        cursor++;
                    break;
                case "B" :
                    if(cursor >= 1) {
                        sb.delete(cursor-1,cursor);
                        cursor--;
                    }
                    break;       
                case "P" :
                    sb.insert(cursor,add);
                    cursor++;
                    break;
            }
            // System.out.println(sb.toString());
        }
        System.out.println(sb.toString());
        
        
    }
}