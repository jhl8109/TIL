import java.io.*;
import java.util.*;

class BOJ_G4_2179{
    public static int N, max = -1;
    public static ArrayList<Dict> arr = new ArrayList<>();
    public static Dict S = new Dict(-1,""), T = new Dict(-1,"");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 
        for(int i=0; i<N;i++) {
            arr.add(new Dict(i,br.readLine()));
        }   
        // Collections.sort(arr);
        for(int i=0; i<N; i++) {
            findPrefix(i);
        }
        System.out.println(S.str);
        System.out.println(T.str);
    }

    public static void findPrefix(int idx){
        int big = -1;
        Dict right = new Dict(-1,"");
        Dict left = arr.get(idx);
        for(int i = idx+1; i< N; i++){
            String tmp = arr.get(i).str;
            int len = Math.min(left.str.length(),tmp.length());
            int save = -1;
            for(int j=0; j<len; j++){
                if(left.str.charAt(j) == tmp.charAt(j)) save = j;
                else break;
            }
            if(save > big) {
                big = save;
                right = arr.get(i);
            } else if(save == big && arr.get(i).index < T.index) {
                right = arr.get(i);
            }
        }
        
        // System.out.printf("left : %s, right : %s, big : %d\n",left.str,right.str, big);
        // System.out.printf("S : %s, T : %s, max : %d\n",S.str,T.str, max);
        if(big > max) {
            S = left;
            T = right;
            max = big;
        } 
    }
    static class Dict implements Comparable<Dict>{
        int index;
        String str;
        Dict(int index, String str){
            this.index = index;
            this.str = str;
        }
        @Override
        public int compareTo(Dict o) {
            return this.str.compareTo(o.str);
        }
    }
}