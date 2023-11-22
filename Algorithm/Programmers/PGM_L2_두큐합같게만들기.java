import java.util.*;

class Solution {
    public static Queue<Integer> q1= new LinkedList<>();
    public static Queue<Integer> q2= new LinkedList<>();
    public int solution(int[] queue1, int[] queue2) {
        int[] sum = calculateSum(queue1, queue2);
        int ratio = sum[0] - sum[1];
        int cnt = 0;
        int size = q1.size();
        while(ratio != 0 && cnt <= size*3 && !q1.isEmpty() && !q2.isEmpty()) {
            if(ratio < 0) {
                int out = q2.poll();
                q1.offer(out);
                ratio += out*2;
                cnt++;
            } else if(ratio > 0) {
                int out = q1.poll();
                q2.offer(out);
                ratio -= out*2;
                cnt++;
            }
        }
        System.out.println();
        System.out.println(ratio);
        if(ratio == 0) return cnt;
        else return -1;
    }
    public static int[] calculateSum(int[] queue1, int[] queue2) {
        int sum1 = 0, sum2=0;
        for(int i=0; i<queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        int[] sum = {sum1,sum2};
        return sum;
    }
}