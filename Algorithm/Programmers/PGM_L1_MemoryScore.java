import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String,Integer> pointMap = new HashMap<>();
        
        for(int i=0; i<yearning.length;i++) {
            pointMap.put(name[i], yearning[i]);
        }
        for(int i=0; i<photo.length;i++){
            int sum = 0;
            for(String target : photo[i]) {
                int point = pointMap.getOrDefault(target,0);
                sum += point;
            }
            answer[i] = sum;
        }

        return answer;
    }
}