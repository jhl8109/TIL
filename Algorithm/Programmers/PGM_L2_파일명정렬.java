import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        List<File> list = new ArrayList<>();
        for(int x=0; x<files.length; x++) {
            String file = files[x];
            int level = 1;
            int i = 0;
            String head = "",number = "",tail= "";
            StringBuilder sb = new StringBuilder();
            while(true) {
                if(level == 1) {
                    if(i < file.length() && !Character.isDigit(file.charAt(i))) {
                        sb.append(file.charAt(i));
                        i++;
                    } else {
                        head = sb.toString();
                        sb = new StringBuilder();
                        level++;
                    }
                } else if (level == 2) {
                    if(i < file.length() && Character.isDigit(file.charAt(i))) {
                        sb.append(file.charAt(i));
                        i++;
                    } else {
                        number = sb.toString();
                        sb = new StringBuilder();
                        level++;
                    }
                } else if (level == 3) {
                    if(i < file.length()) {
                        sb.append(file.charAt(i));
                        i++;
                    } else {
                        tail = sb.toString();
                        sb = new StringBuilder();
                        break;
                    }
                }
            }
            list.add(new File(x, head,number,tail));
        }
        Collections.sort(list);
        answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = String.format("%s%s%s", list.get(i).head, list.get(i).number, list.get(i).tail);
        }
        return answer;
    }
    static class File implements Comparable<File>{
        int idx;
        String head,number,tail;
        
        File(int idx,String head, String number, String tail) {
            this.idx = idx;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        @Override
        public int compareTo(File o) {
            if(this.head.compareToIgnoreCase(o.head) == 0) {
                if(Integer.parseInt(this.number) == Integer.parseInt(o.number)) {
                    return this.idx - o.idx;
                } else return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            } else return this.head.compareToIgnoreCase(o.head);
        }
    }
}
