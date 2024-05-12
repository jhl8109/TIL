import java.util.*;

class Solution {
    
    public int solution(int m, int n, String[] board1) {
        int answer = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(visited[i], false);
        }
        char[][] board = new char[m][n];
        for(int i=0; i<m; i++) {
            board[i] = board1[i].toCharArray();
        }
        boolean check = false;
        while(true) {
            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    if(check4Block(board, i,j)){
                        check = true;
                        visited[i][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j] = true;
                        visited[i+1][j+1] = true;
                        // System.out.printf("(%d, %d)\n",i,j);
                    } 
                }
            }  
            answer += countAnswer(board,visited, m,n);
            if(!check) break;
            check=false;
            getDown(board,visited,m,n);
            // for(int i=0; i<m; i++) {
            //     System.out.println(new String(board[i]));
            // }
            // System.out.println();
            for(int i=0; i<m; i++) {
                Arrays.fill(visited[i], false);
            }
        }
        return answer;
    }
    public boolean check4Block(char[][] board, int y, int x) {
        char target = board[y][x];
        if(target == 'x') return false;

        return board[y][x+1] == target && 
            board[y+1][x] == target && 
            board[y+1][x+1] == target;
    }
    public int countAnswer(char[][] board,boolean[][] visited, int m, int n) {
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j]) {
                    count++;
                    board[i][j] = 'x';
                }
            }
        }
        return count;
    }
    public void getDown(char[][] board, boolean[][] visited, int m,int n) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<n; i++) { // 가로
            for(int j=0; j<m; j++) { // 세로
                if(!visited[j][i]) {
                    s.push(board[j][i]);
                    board[j][i] = 'x';
                }
            }
            int size = s.size();
            for(int j=m-1; j>m-1-size; j--){
                char value = s.pop();
                board[j][i] = value;
                // System.out.printf("(%d, %d, %c)\n",j,i,value);
            }
        }
        // for(int i=0; i<m; i++) {
        //     System.out.println(new String(board[i]));
        // }
        // System.out.println();
    }
}