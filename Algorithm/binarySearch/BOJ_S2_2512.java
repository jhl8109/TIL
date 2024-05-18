import java.util.*;
import java.io.*;

class BOJ_S2_2512 {
    public static int N, max;
    public static Integer[] arr;

    public static int solution(int sum) {
        int right = arr[0], left = arr[N-1];

        while(left <= right) {
            int mid = (left+right)/2;
            long budget = 0;
            for(int i=0; i<N; i++) {
                if(arr[i] > mid) budget += mid;
                else budget += arr[i];
            }
            if(budget == max) return right;
            else if(budget < max) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
    public static void main(String[] args) throws IOException{
        BOJ_S2_2512_2 main = new BOJ_S2_2512_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new Integer[N];

        st = new StringTokenizer(br.readLine());
        
        int sum = 0;
        // Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // arr = Arrays.sort(arr2,Collections.reverseOrder());
       
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr,Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        max = Integer.parseInt(st.nextToken());

        if(sum <= max) System.out.println(arr[0]);
        else System.out.println(solution(sum));

    }
}