import java.io.*;
import java.util.*;

public class BOJ_G2_1655 {
    private static int N;
    // 짝수개 + 작은거 => 그대로 + 왼쪽 힙 넣기
    // 짝수개 + 큰거 => 다음거(오른쪽힙 뽑기) + 현재걸 왼쪽힙 넣기 + 오른쪽 힙 넣기
    // 홀수개 + 작은거 => 이전 거(왼쪽힙 뽑기) + 현재걸 오른쪽힙 넣기
    // 홀수개 + 큰거 => 그대로 + 오른쪽 힙 넣기
    // 유지해야하는 변수 => 중간값, 왼쪽 힙, 오른쪽 힙 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int medium = Integer.parseInt(br.readLine());
        sb.append(medium);
        boolean pair = false; // 현재 짝/홀
        
        for(int i=1; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(pair) {
                if(input <= medium) {
                    left.offer(input);
                } else {
                    left.offer(medium);
                    right.offer(input);
                    medium = right.poll();
                }
            } else {
                if(input <= medium) {
                    left.offer(input);
                    right.offer(medium);
                    medium = left.poll();
                } else {
                    right.offer(input);
                }
            }
            pair = !pair;
            sb.append("\n"+medium);
        }
        System.out.println(sb.toString());
    }
}