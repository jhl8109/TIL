import java.util.*;

class PGM_L2_우박수열 {
    public double[] solution(int k, int[][] ranges) {
        // n은 1이 될때까지 걸린 횟수
        int target = k;
        int n = 0;
        List<int[]> points = new ArrayList<>();
        points.add(new int[]{0,k});
        while(target != 1) {
            if(target % 2 == 0) {
                target /= 2;
            } else {
                target = target * 3 + 1;
            }
            n++;
            points.add(new int[]{n,target});
        }
        List<Double> sum = new ArrayList();
        for(int i=1; i<points.size(); i++) {
            int[] p1 = points.get(i-1);
            int[] p2 = points.get(i);
            sum.add((double)(p1[1] + p2[1])/2);
        }
        double[] answers = new double[ranges.length];
        for(int i=0; i<ranges.length; i++) {
            double answer;
            int start = ranges[i][0];
            int end = n+ranges[i][1];            
            // System.out.println(start + " , " + end);
            if(end < start) answer = -1L;
            else if(end == start) answer = 0L;
            else {
                double s = 0;
                // System.out.println(sum.size());
                for(int j=start; j<end; j++) {
                    s += sum.get(j);
                }
                answer = s;
            }
            answers[i] = answer;
        }
        return answers;
    }
}