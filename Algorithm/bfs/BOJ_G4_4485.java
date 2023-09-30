import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;

class BOJ_G4_4485{
	
	public static boolean checkBoard(int dy, int dx, int T) {
		if(dy >= 0 && dy < T && dx >= 0 && dx < T)
			return true;
		else 
			return false;
	}
	public static int solution(int[][] board, int T) {
		int[] ny = {-1,1,0,0};
		int[] nx = {0,0,-1,1};
		Queue<Point> q = new LinkedList<Point>();
		int[][] visited = new int[T][T];
		for(int i=0; i<T; i++) {
			Arrays.fill(visited[i],Integer.MAX_VALUE);
		}
		
		int minimum = Integer.MAX_VALUE;
		q.offer(new Point(0,0,board[0][0]));
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(cur.cost < visited[cur.y][cur.x]) {
				visited[cur.y][cur.x] = cur.cost;
			} else 
				continue;
			
			if(cur.y == T-1 && cur.x == T-1 && cur.cost < minimum) 
				minimum = cur.cost;
			
			for(int i=0; i<4; i++) {
				int dy = cur.y + ny[i];
				int dx = cur.x + nx[i];
				
				if(checkBoard(dy,dx,T)) {
					int dCost = cur.cost + board[dy][dx];
					q.offer(new Point(dy,dx,dCost));
				}
			}
		}
		
		return minimum;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int idx=0;
		while(T != 0) {
			int[][] board = new int[T][T];
			for(int i=0; i<T; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<T; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			idx++;
			int minimum = solution(board,T);			
			System.out.printf("Problem %d: %d\n",idx, minimum);
			

			T = Integer.parseInt(br.readLine());
		}
	}
	static class Point{
		int y;
		int x;
		int cost;
		Point(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
}