import java.util.*;
import java.io.*;

class BOJ_G4_1987{
	static int R,C;
	static int[] ny = {1,-1,0,0};
	static int[] nx = {0,0,-1,1};
	static int max = 1;

	public static boolean checkBoundary(int dy,int dx) {
		if(dy >= 0 && dy < R && dx >= 0 && dx < C) return true;
		else return false;
	}

	public static void DFS(char[][] board, StringBuilder sb, int y, int x) {
		// System.out.println(sb.toString());
		for(int i=0; i<4; i++) {
			int dy = y + ny[i];
			int dx = x + nx[i];
			
			if(checkBoundary(dy,dx) && !sb.toString().contains(Character.toString(board[dy][dx]))){
				sb.append(board[dy][dx]);
				max = Math.max(max, sb.length());
				DFS(board,sb,dy,dx);
				sb.delete(sb.length()-1, sb.length());
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] board = new char[R][C];

		for(int i=0; i<R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		StringBuilder sb = new StringBuilder();
		sb.append(board[0][0]);
		DFS(board,sb, 0,0);
		System.out.println(max);
	}
}