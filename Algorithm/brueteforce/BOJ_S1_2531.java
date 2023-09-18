import java.util.*;
import java.io.*;

class BOJ_S1_2531{
    public static int N, d, k, c;
    public static int[] belts;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        belts = new int[N+k];
        for(int i=0; i<N; i++) {
            belts[i] = Integer.parseInt(br.readLine());
            if(i < k) {
                belts[N+i] = belts[i];
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        

        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0; i<k; i++ ){
            int val = map.getOrDefault(belts[i],0);
            map.put(belts[i],val+1);
            if(belts[i] != c && val == 0) { // 쿠폰도 아니고 연속 배열에 포함되어 있지도 않으면,
                count++;
            }
            max = Math.max(max,count);
        }

        
        for(int i=k; i<N+k; i++) {            
            int val = map.getOrDefault(belts[i],0);
            if(belts[i] != c && val == 0) { // 쿠폰도 아니고 연속 배열에 포함되어 있지도 않으면,
                count++;
            }
            map.put(belts[i],val+1);
            int rm = map.get(belts[i-k]);
            if(rm == 1) {
                map.remove(belts[i-k]);
                if(belts[i-k] != c)
                    count--;
            }
            else map.put(belts[i-k], rm-1);
            max = Math.max(max,count);
            // System.out.println(belts[i] + ": " +count);
        }
        System.out.println(max+1);
    }
}