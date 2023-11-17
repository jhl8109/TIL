import java.util.*;

class Solution {
    public static int T;
    public int[] solution(int N, int[] stages) {
        T = N;
        int[] answer = new int[N];
        Stat[] stat = new Stat[N+2];
        stat[0] = new Stat(0,-1,0);
        for(int i=1; i<=N+1; i++) {
            stat[i] = new Stat(i,1,0);
        }
        Arrays.sort(stages);
        int i=0;
        while(i < stages.length) {
            int stage = stages[i];
            int total = stages.length - i;
            int cur = 1;
            while(i+1 < stages.length && stages[i+1] == stage) {
                cur++;
                i++;
            }
            i++;
            stat[stage] = new Stat(stage,total,cur);
        }
        Arrays.sort(stat);
        
        for(int j=0; j<N; j++) {
            answer[j] =stat[j].stage;
        }
        return answer;
    }
    static class Stat implements Comparable<Stat>{
        int stage;
        int total;
        int cur;
        Stat(int stage, int total, int cur) {
            this.stage = stage;
            this.total = total;
            this.cur = cur;
        }
        @Override
        public int compareTo(Stat o) {
            double t1 = (double) this.cur/this.total;
            double t2 = (double) o.cur/o.total;
            if(o.stage == 0 || o.stage == T+1) { // 0, N+1 의 숫자를 채우기 위한 데이터
                return -1;
            } else if(this.stage == 0 || this.stage == T+1) {
                return 1;
            }
            if(t1 == t2) {
               return this.stage - o.stage; 
            } 
            double tmp = t1 - t2;
            if(tmp < 0) return 1;
            else return -1;
        }
    }
}