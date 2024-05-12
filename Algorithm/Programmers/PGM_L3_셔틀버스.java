import java.util.*;

class Solution {
    public static  Map<Integer,List<Integer>> map = new TreeMap<>();

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int start = 540;
        for(int i=0; i<n; i++) {
            List<Integer> list = new ArrayList<>();
            map.put(start, list);
            start += t; 
        }
        Arrays.sort(timetable);
        for(String time : timetable) {
            int intTime = toMinute(time);
            rideShuttle(intTime,m);
        }
        // for(int key : map.keySet()) {
        //     List<Integer> list = map.get(key);
        //     System.out.printf("%d : ", key);
        //     for(int i=0; i<list.size(); i++) {
        //         System.out.printf("%d ",list.get(i));
        //     }
        //     System.out.println();
        // }
        System.out.println(Arrays.toString(timetable));
        int ans = findShuttle(m);
        String HH, MM;
        if (ans/60 < 10) HH = "0" + String.valueOf(ans/60);
        else HH = String.valueOf(ans/60);
        if (ans%60 < 10) MM = "0" + String.valueOf(ans%60);
        else MM = String.valueOf(ans%60);
        answer = HH + ":" + MM;
        return answer;
    }
    public static int toMinute(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    public static void rideShuttle(int time, int m) {
        for(int key : map.keySet()) {
            if(time <= key && map.get(key).size() < m) {
                map.get(key).add(time);
                break;
            }
        }
    }
    public static int findShuttle(int m) {
        int late = 0;
        for(int key : map.keySet()) {
            if(map.get(key).size() < m) {
                late = Math.max(late,key);
            } else {
                List<Integer> list = map.get(key);
                late = Math.max(late, list.get(list.size()-1)-1);
            }
        }
        return late;
    }
}