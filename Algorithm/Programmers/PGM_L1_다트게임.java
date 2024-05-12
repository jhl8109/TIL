import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int score = 0;
        int bonus = 0;
        int opt = 1;
        for(int i=0; i<dartResult.length(); i++) {
            char point = dartResult.charAt(i);
            if (Character.isDigit(point)) {
                score = 0;

                list.add(bonus * opt);
                System.out.printf("%d, %d * %d \n",score,bonus,opt);
                
                opt = 1;
                if(Character.isDigit(dartResult.charAt(i+1))) {
                    score = Character.getNumericValue(point) * 10;
                    i++;
                }
                score += Character.getNumericValue(dartResult.charAt(i));
            } else if (Character.isAlphabetic(point)) {
                if(point == 'S') {
                    bonus = score;
                } else if(point == 'D') {
                    bonus = (int) Math.pow(score,2);
                } else if (point == 'T') {
                    bonus = (int) Math.pow(score,3);
                }
                System.out.println("bonus : " + bonus);
            } else {
                if(point == '*') {
                    opt = 2; 
                    int id = list.size()-1;
                    list.set(id,list.get(id) * opt);
                } else { // '#'
                    opt = opt* (-1);
                }
            }
        }
        list.add(bonus*opt);
        for(int tmp : list){
            System.out.printf("%d ,",tmp);
            answer += tmp;
        }
        
        return answer;
    }
}