import java.util.*;

class Solution {
    static int need;
    static int[] arr;
    static int sum;
    static int answer;
    public int returnValue(int pick, String mineral) {
        if(pick == 0) 
            return 1;
        else if(pick == 1) {
            if(mineral.equals("diamond")) 
                return 5;
            else return 1;
        } else {
            if(mineral.equals("diamond"))
                return 25;
            else if(mineral.equals("iron"))
                return 5;
            else return 1;
        }
    }
    
    public void DFS(int start, int pick, int[] picks, String[] minerals, int[] arr) {
        for(int i=start; i<start+5; i++) {
            if(i >= minerals.length) {
                answer = Math.min(answer, arr[sum-1]);
                break;
            }
            if(i == 0) {
                arr[i] = Math.min(arr[i],returnValue(pick, minerals[i]));
            } else {
                arr[i] = Math.min(arr[i],arr[i-1] + returnValue(pick,minerals[i]));
            }
        }
        // System.out.println(start+ ","+pick + ", "+ Arrays.toString(arr));
        answer = Math.min(answer, arr[sum-1]);
        if(start+5 >= minerals.length) {
            answer = Math.min(answer, arr[sum-1]);
            // System.out.println(arr[sum-1]);
            return;
        }
        for(int i=0; i<picks.length; i++) {
            if(picks[i] > 0) { // 곡괭이가 존재하면 해당 곡괭이를 기준으로 picks 조합 생성
                picks[i]--; // 곡괭이 차감
                DFS(start+5,i,picks,minerals, arr.clone());
                picks[i]++; // 곡괭이 복구
            }
        }
    }
    public int solution(int[] picks, String[] minerals) {
        answer = 1000000;
        arr = new int[minerals.length]; // 최소값을 저장하는 배열
        need = minerals.length/5; // 필요한 곡괭이의 수

        for(int j=0; j<minerals.length; j++)
            arr[j] = 1000000;
        
        sum = 0;
        for(int i=0; i<picks.length; i++) {
            sum += picks[i];
        }
        sum *= 5; // 곡괭이로 캘수있는 광물의 수
        sum = Math.min(sum, minerals.length);
        // System.out.println(sum);
        for(int i=0; i<picks.length; i++) {
            if(picks[i] > 0) { // 곡괭이가 존재하면 해당 곡괭이를 기준으로 picks 조합 생성               
                picks[i]--; // 곡괭이 차감
                DFS(0,i,picks,minerals, arr.clone());
                picks[i]++; // 곡괭이 복구               
                
            }
        }
        
        return answer;
    }
}