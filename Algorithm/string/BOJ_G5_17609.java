import java.util.*;
import java.io.*;

class BOJ_G5_17609{
    public static int N;
    public static int isPalindrome(String target, boolean check) {
        // System.out.println(target);
        int answer = 0;
        // 회문
        for(int i=0; i<=target.length()/2; i++) {
            if (target.charAt(i) != target.charAt(target.length()-1-i)) {
                if(!check) {
                    check = true;
                    int a = isPalindrome(target.substring(0,i) + target.substring(i+1,target.length()), check);
                    int b = isPalindrome(target.substring(0,target.length()-1-i) + target.substring(target.length()-i, target.length()), check);
                    if(a == 0 || b == 0) {
                        // System.out.println(a + " : " + b);
                        answer = 1;
                    } else {
                        answer = 2;
                    }
                }
                else {
                    answer = 2;
                }
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String tmp = br.readLine();
            bw.write(isPalindrome(tmp, false)+"\n");
            // System.out.println(isPalindrome(tmp, false));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}