class Solution {
    public static String str;
    public int solution(String s) {
        str = s;
        String candidate = "";
        int answer = s.length();
        for(int i=1; i<=s.length(); i++) {
            String tmp = zip(i);
            if(candidate.length() == 0 || tmp.length() < candidate.length())
                candidate = tmp;
        }
        return candidate.length();
    }
    public static String zip(int size) {
        String prev = str.substring(0,size);
        String next = "";
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=size; i<=str.length(); i+=size) {
            if(str.length() < i+size) {
                if(cnt == 1) {
                    sb.append(prev);
                }else {
                    sb.append(String.valueOf(cnt) + prev);
                }
                sb.append(str.substring(i,str.length()));
                break;
            }
            next = str.substring(i,i+size);
            if(next.equals(prev)) cnt++;
            else {
                if(cnt == 1) {
                    sb.append(prev);
                }
                else {
                    sb.append(String.valueOf(cnt) + prev);
                    cnt=1;
                }
                prev = next;
            }
        }
        return sb.toString();
    }
}