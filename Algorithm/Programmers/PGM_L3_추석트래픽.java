import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Solution {
    public int solution(String[] lines) {
        int answer = 1;
        List<Timestamp> times = new ArrayList<>();
        for(String line:lines){
            String[] spaceSplit = line.split(" ");
            String[] colonSplit = spaceSplit[1].split(":");
            String[] dotSplit = colonSplit[2].split("\\.");
            
            int hour = Integer.parseInt(colonSplit[0]);
            int minute = Integer.parseInt(colonSplit[1]);
            int second = Integer.parseInt(dotSplit[0]);
            int millisecond = Integer.parseInt(dotSplit[1]);
            
            int endTime = ((hour * 60 + minute) * 60 + second) * 1000 + millisecond;
            int processDuration = (int) (Float.parseFloat(spaceSplit[2].substring(0, spaceSplit[2].length() - 1)) * 1000);
            int startTime = endTime - processDuration + 1;
            
            times.add(new Timestamp(startTime,endTime));
        }



        
        for(int i=0; i<times.size(); i++) {
            int cnt = 0;
            long endRange = times.get(i).end;
            for(int j=i; j<times.size(); j++) {
                if(times.get(j).start < endRange+1000L ) {
                    cnt++;                
                }
            }
            answer = Math.max(answer,cnt);
        }
      
        return answer;
    }
    static class Timestamp{
        long start,end;
        
        Timestamp(long start, long end) {
            this.start = start;
            this.end = end;
        }
        
    }
}