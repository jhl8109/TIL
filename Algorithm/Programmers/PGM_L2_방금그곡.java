import java.util.*;
//C, C#, D, D#, E, F, F#, G, G#, A, A#, B
// C#, D#, F#, G#, A#
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        MusicInfo song = null;
        m = m.replaceAll("C#","c")
         .replaceAll("D#","d")
         .replaceAll("F#","f")
         .replaceAll("G#","g")
         .replaceAll("A#","a"); 
        List<MusicInfo> list = new ArrayList<>();
        for(String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            int duration = toIntTime(info[0],info[1]);
            info[3] = info[3].replaceAll("C#","c")
             .replaceAll("D#","d")
             .replaceAll("F#","f")
             .replaceAll("G#","g")
             .replaceAll("A#","a"); 
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<duration; i++) {
                sb.append(info[3]);
            }
            String s = sb.substring(0,duration).toString();
            list.add(new MusicInfo(duration,info[2],s));
        }
        for(MusicInfo musicinfo : list) {
            if(musicinfo.melody.contains(m)) {
                    if(song == null) song = musicinfo;
                    else if(song.duration < musicinfo.duration) song = musicinfo;
            }
        }
        if(song != null) answer = song.title;
        return answer;
    }
    public static int toIntTime(String start, String end) {
        String[] time = start.split(":");
        int startTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        time = end.split(":");
        int endTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        return endTime - startTime;
    }
    static class MusicInfo {
        int duration;
        String title;
        String melody;
        
        MusicInfo(int duration, String title, String melody) {
            this.duration = duration;
            this.title = title;
            this.melody = melody;
        }
    }
}