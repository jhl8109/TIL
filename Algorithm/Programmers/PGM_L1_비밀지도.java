import java.util.*; 

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];
        char[][] map = new char[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(map[i],' ');
        }
        for(int i=0; i<n; i++) {
            String bin = Integer.toBinaryString(arr1[i]);
            int padding = n-bin.length();
            for(int j=padding; j<n; j++) {
                if(bin.charAt(j-padding) == '1')
                    map[i][j] = '#';
            }
        }
        for(int i=0; i<n; i++) {
            String bin = Integer.toBinaryString(arr2[i]);
            int padding = n-bin.length();
            for(int j=padding; j<n; j++) {
                if(bin.charAt(j-padding) == '1')
                    map[i][j] = '#';
            }
        }
        for(int i=0; i<n; i++ ){
            System.out.println(Arrays.toString(map[i]));
            answer[i] = new String(map[i]);
        }

        return answer;
    }
}