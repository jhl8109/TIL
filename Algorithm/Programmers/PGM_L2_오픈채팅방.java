import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Queue<Action> q = new LinkedList<>();
        Map<String,String> map = new HashMap<>();
        for(String rec : record) {
            String[] arr = rec.split(" ");
            switch(arr[0]) {
                case "Enter":
                    map.put(arr[1],arr[2]);
                    q.offer(new Action(arr[1],arr[0]));
                    break;
                case "Leave":
                    q.offer(new Action(arr[1],arr[0]));
                    break;
                case "Change":
                    map.put(arr[1],arr[2]);
                    break;
            }
        }
        int size = q.size();
        String[] answer = new String[size];
        for(int i=0; i<size; i++) {
            Action action = q.poll();
            // System.out.printf("%s %s\n",action.action,action.uid);
            if(action.action.equals("Enter")) {
                answer[i] = String.format("%s님이 들어왔습니다.",map.get(action.uid));
            } else if(action.action.equals("Leave")) {
                answer[i] = String.format("%s님이 나갔습니다.",map.get(action.uid));
            }
            
        }
        return answer;
    }
    static class Action {
        String uid;
        String action;
        Action(String uid, String action) {
            this.uid = uid;
            this.action = action;
        }
    }
}