import java.util.*;

class Solution {
    // 1 : R,T
    // 2 : C,F
    // 3 : J,M
    // 4 : A,N
    public String solution(String[] survey, int[] choices) {
        int[] records = new int[4];
        int[] scores = {0,3,2,1,0,-1,-2,-3};
        String[][] types= {{"R","T"},{"C","F"},{"J","M"},{"A","N"}};
        Arrays.fill(records,0);
        for(int i=0; i<survey.length; i++) {
            int score = scores[choices[i]];
            if(survey[i].charAt(0) == 'T' ||survey[i].charAt(0) == 'F'
              || survey[i].charAt(0) == 'M' || survey[i].charAt(0) == 'N') 
                score *= -1;
            if(survey[i].matches("RT|TR")) records[0] += score;
            else if(survey[i].matches("CF|FC")) records[1] += score;
            else if(survey[i].matches("JM|MJ")) records[2] += score;
            else if(survey[i].matches("AN|NA")) records[3] += score;
            else System.out.println("??");
        }
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<4; i++) {
            if(records[i] >= 0) answer.append(types[i][0]);
            else answer.append(types[i][1]);
        }
        System.out.println(Arrays.toString(records));
        
        return answer.toString();
    }
}