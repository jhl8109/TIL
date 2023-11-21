import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<String[]> targets = new ArrayList<>();
        boolean check = false;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<s.length()-1; i++) {
            if(s.charAt(i) == '{') {
                check = true;
            } else if(s.charAt(i) == '}') {
                String[] target = sb.toString().split(",");
                targets.add(target);
                check = false;
                sb.setLength(0);
            } else if(check) {
                sb.append(s.charAt(i));
            }
        }
        int[] answer = new int[targets.size()];
        Arrays.fill(answer, 0);
        Collections.sort(targets, new Comparator<String[]>() {
            @Override
            public int compare(String[] a1, String[] a2) {
                return a1.length - a2.length;
            }
        });
        for(int i=0; i<targets.size(); i++) {
            String[] target = targets.get(i);
            for(int j=0; j<target.length; j++) {
                boolean isExist = false;
                for(int k=0; k<target.length-1; k++) {
                    if(answer[k] == Integer.valueOf(target[j])) {
                        isExist = true;
                        break;
                    }
                }
                if(!isExist) {
                    answer[i] = Integer.valueOf(target[j]);
                    break;
                }
            }
        }
        return answer;
    }
}