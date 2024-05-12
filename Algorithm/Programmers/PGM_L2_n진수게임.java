import java.util.*;

class Solution {
    public static char[] arr = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<100000; i++) {
            int x = i;
            while(true) {
                if(x < n) {
                    s.push(arr[x]);
                    break;
                } else {
                    int tmp = x % n;
                    s.push(arr[tmp]);
                    x /= n;
                }
            }
            int size = s.size();
            for(int j=0; j<size; j++) {
                sb.append(s.pop());
            }
        }
        for(int i=p-1; i<t*m; i+=m) {
            answer.append(sb.charAt(i));
        }
        
        
        return answer.toString();
    }
}