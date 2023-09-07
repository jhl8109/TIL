import java.util.*;
import java.io.*;

class BOJ_S2_2512 {
    public static int N, max;
    public static Integer[] arr;

    public static int solution(int sum) {
        int substract = sum - max;
        for(int i=0; i<N; i++) {
            int partialSum = 0, limited = 0;
            for(int j=0; j<=i; j++){
                partialSum += arr[j];
            }
            limited = (partialSum-substract)/(i+1); // 그 partialSum - 부분 합이 = substract
            if (i+1 == N || limited >= arr[i+1]) return limited;
            else continue;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException{
        BOJ_S2_2512 main = new BOJ_S2_2512();
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