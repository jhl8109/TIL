import java.util.*;

class Solution {
    public static String target;
    public String solution(String p) {
        String answer = "";
        target = p;
        boolean result = isAnswer(target);
        if(result) return p;
        else {
            answer = recursion(target);
        }
        return answer;
    }
    public static String recursion(String result) {
        if(result.length() == 0) return "";
        String[] ret = splitUW(result);
        String u = ret[0], v = ret[1];
        if(isAnswer(u)) return u + recursion(v);
        else{
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(recursion(v));
            sb.append(')');
            for(int i=1; i<u.length()-1; i++) {
                if(u.charAt(i) == '(') sb.append(')');
                else sb.append('(');
            }
            return sb.toString();
        }
    }
    public static boolean isAnswer(String t) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<t.length(); i++) {
            if(t.charAt(i) == '(') {
                s.push('(');
            } else if(t.charAt(i) == ')') {
                if((!s.isEmpty() && s.peek() == '(')) {
                    s.pop();
                } else return false;
            } 
        }
        return true;
    }
    public static String[] splitUW(String t) {
        Stack<Character> s = new Stack<>();
        int left = 0;
        int right = 0;
        int match = Integer.MAX_VALUE;
        for(int i=0; i<t.length(); i++) {
            if(t.charAt(i) == '(') {
                s.push('(');
                left++;
            } else if(t.charAt(i) == ')') {
                right++;
                if((!s.isEmpty() && s.peek() == '(')) {
                    s.pop();
                } 
            } 
            if(left == right) match = Math.min(match,left + right);
        }
        String[] result = {t.substring(0,match), t.substring(match,t.length())};
        return result;
    }
}