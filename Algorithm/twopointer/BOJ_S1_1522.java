import java.util.*;
import java.io.*;

class BOJ_S1_1522{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] target = input.toCharArray();
        int count = 0;
        for(int i=0; i<target.length; i++) {
            if(target[i] == 'a') count++; // a의 총 갯수를 셈
        }
        int min = Integer.MAX_VALUE;
        int change = 0;
        for(int i=0; i<count; i++) {
            if(target[i] == 'b') change++;
        }
        min = Math.min(min,change);
        for(int i=count; i<target.length+count; i++) {
            if(target[i%target.length]== 'b') {
                change++;
            }
            if(target[i-count] == 'b') {
                change--;
            }
            min = Math.min(min,change);
        }
        System.out.println(min);
    }
}