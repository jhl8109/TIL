import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i=1; i<=26; i++) {
            char x = (char) (65-1+i);
            map.put(Character.toString(x),i);
        }
        int endPoint = 27;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<msg.length(); i++) {
            int idx = map.get(Character.toString(msg.charAt(i)));
            sb.setLength(0);
            sb.append(msg.charAt(i));
            for(int j=i+1; j<msg.length(); j++) {
                sb.append(msg.charAt(j));
                int check = map.getOrDefault(sb.toString(),-1);
                if(check == -1) {
                    map.put(sb.toString(), endPoint++);
                    break;
                } else {
                    idx = check;
                    i = j; 
                }
            }
            answer.add(idx);
        }
        int[] arr = answer.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}