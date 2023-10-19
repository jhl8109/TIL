import java.io.*;
import java.util.*;

class BOJ_G4_9935{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        boolean check = false, prev = false;;
        int count = 0;
        
        Stack<Character> s = new Stack<>();
                for(int i=0; i<input.length; i++) {
                    if(input[i] == bomb[count]) {
                        count++;
                        prev = true;
                    } else if(prev) {
                        count = 0;
                        if(input[i] == bomb[count]) count = 1;
                        prev = false;
                    }
                    s.add(input[i]);
                    if(count == bomb.length) {
                        int cut = bomb.length;
                        while(cut > 0) {
                            s.pop();
                            cut--;
                        }
                        check = true;
                        count=0;
                        for(int j=bomb.length; j>0; j--) { // 이전 값들에 폭발 문자열이 있을 수 없음 -> 즉 무조건 삭제 후 생기는 폭발 문자열 중 한 문자는 뒤 있음
                            if(s.size()-j < 0) continue;
                            if (s.get(s.size()-j) == bomb[count]) {
                                count++;
                                prev = true;
                            } else if(prev) {
                                count = 0;
                                if(s.get(s.size()-j) == bomb[count]) count = 1;
                                prev = false;
                            }
                        }
                    }
                }
            StringBuilder sb = new StringBuilder();
            for(Character c : s.toArray(new Character[s.size()])){
                sb.append(c);
            }
            System.out.println(sb.toString().equals("") ? "FRULA" : sb.toString());
        }
    

}