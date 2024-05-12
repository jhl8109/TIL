import java.util.*;

class Solution {
    public static String[] words = {};
    public int solution(String s) {
        int answer = 0; 
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                answer = answer * 10 + Character.getNumericValue(c);
            } else {
                sb.append(c);
            }
            if(map.getOrDefault(sb.toString(), -1) != -1){
                answer = answer * 10 + map.get(sb.toString());
                sb.setLength(0);
            }
        }
       return answer;
    }
}