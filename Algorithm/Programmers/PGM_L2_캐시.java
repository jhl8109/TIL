import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        if(cacheSize == 0) return 5 * cities.length;
        for(String city : cities) {
            int idx = list.indexOf(city.toLowerCase());
            if(idx == -1) {
                if(!list.isEmpty() && list.size() >= cacheSize) list.remove(0);
                list.add(city.toLowerCase());
                answer += 5;
            } else {
                list.remove(idx);
                list.add(city.toLowerCase());
                answer += 1;
            }
            // System.out.printf("%d, %d\n",answer,list.size());
        }
        return answer;
    }
}