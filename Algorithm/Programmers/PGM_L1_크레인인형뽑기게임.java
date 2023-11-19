import java.util.*;

class Solution {
    static int[][] board;
    static int[] moves;
    static int depth;
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        this.board = board;
        this.moves = moves;
        this.depth = board.length;
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<moves.length; i++) {
            int popOut = out(moves[i]-1);
            // System.out.println(popOut);
            if(popOut != 0) {
                if(!s.isEmpty() && s.peek() == popOut) {
                    s.pop();
                    answer += 2;
                } else {
                    s.push(popOut);
                }
            }
        }
        
        
        return answer;
    }
    public static int out(int move) {
        for(int i=0; i<depth; i++) {
            if(board[i][move] != 0) {
                int tmp = board[i][move];
                board[i][move] = 0;
                return tmp;
            }
        }
        return 0;
    }
}