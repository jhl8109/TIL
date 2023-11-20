import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String word, String[] pages) {
        // 기본 점수 : 검색어가 등장하는 횟수
        // 외부 링크 수 : 외부 페이지로 연결된 링크으 ㅣ개수
        // 링크 점수 : 다른 웹페이지의 기본 점수 / 외부 링크 수 총합
        String[] url = new String[pages.length];
        int[] baseScore = new int[pages.length];
        int[] linkCount = new int[pages.length];
        int[] linkScore = new int[pages.length];
        Map<String,Stat> map = new HashMap<>();
        for(int i=0; i<pages.length; i++) {
            // url 찾기
            Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
            Matcher matcher = pattern.matcher(pages[i]);
            while (matcher.find()) {
                url[i] = matcher.group(1);
            }
            // baseScore 계산
            int idx = 0;
            int cnt = 0;
            String leftPage = pages[i].toLowerCase();
            word = word.toLowerCase();
            
            while(true) {
                idx = leftPage.indexOf(word);
                if ((idx + word.length() == leftPage.length() 
                    || !Character.isLetter(leftPage.charAt(idx + word.length())))
                    && idx != -1) cnt++;
                else break;
                leftPage = leftPage.substring(idx+word.length());
            }
            map.put(url[i], new Stat(i,cnt,0,0));
            baseScore[i] = cnt;
            System.out.println(cnt);
        }
        
        for(int i=0; i<pages.length; i++) {
            //linkCount 찾기
            int cnt = 0;
            int idx = pages[i].indexOf("content=");
            String[] page = pages[i].substring(idx+9).split("\"");
            String leftPage = pages[i].substring(idx+6 + page[0].length());
            while(true) {
                idx = leftPage.indexOf("href=");
                if(idx != -1) cnt++;
                else break;
                page = leftPage.substring(idx+6).split("\"");
                leftPage = leftPage.substring(idx+6 + page[0].length());
            }
            Stat p = map.get(url[i]);
            p.linkCount = cnt;
            map.put(url[i],p);
        }
         for(int i=0; i<pages.length; i++) {
            //linkScore 찾기
            double score = 0;;
            Stat stat = map.get(url[i]);
            Pattern pattern = Pattern.compile("<a href=\"https://(.+?)\">");
            Matcher matcher = pattern.matcher(pages[i]);
                while (matcher.find()) {
                    String targetUrl = matcher.group(1);
                    if (map.containsKey(targetUrl)) {
                        map.get(targetUrl).linkScore += (double) stat.baseScore / stat.linkCount;
                    }
                }
        }
        Stat[] arr = new Stat[pages.length];
         for(int i=0; i<pages.length; i++) {
            Stat stat = map.get(url[i]);
            arr[i] = stat;
         }
        Arrays.sort(arr);
        return arr[0].seq;
    }

    static class Stat implements Comparable<Stat>{
        int seq;
        int baseScore;
        int linkCount;
        double linkScore;
        
        public Stat(int seq, int baseScore, int linkCount, double linkScore) {
            this.seq = seq;
            this.baseScore = baseScore;
            this.linkCount = linkCount;
            this.linkScore = linkScore;
        }
        
        @Override
        public int compareTo(Stat o) {
            double t1 = this.baseScore + this.linkScore;
            double t2 = o.baseScore + o.linkScore;
            if(t1 == t2) 
                return this.seq - o.seq;
            if(t1 > t2) return -1;
            else return 1;
        }
    }
}