import java.util.*;

class Video {
	public int p;
	public int q;
	public int r;
	Video(int p, int q, int r) {
		this.p = p;
		this.q = q;
		this.r = r;
	}
}

class Main {
	static int R,C,K,answer;
	static char[][] board;
	static int[][] visited;
	public void DFS(int y, int x, int dist){
		int[] dy = {-1,0,1,0};
		int[] dx = {0,1,0,-1};
		if(dist == K && y == 0 && x == C-1) {
			answer++;
			return;
		} else if(dist >= K || (y == 0 && x == C-1)) {
			return;
		}
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny >= 0 && ny <= R-1 && nx >=0 && nx<=C-1 && board[ny][nx] =='.' && visited[ny][nx] == 0) {
				// System.out.println(ny +","+nx+","+String.valueOf(dist+1));
				visited[ny][nx] = 1;
				DFS(ny,nx,dist+1);
				visited[ny][nx] = 0;
			}
		}
	}
	public static void main(String[] args){
		Main main = new Main();
		Scanner kb = new Scanner(System.in);
		R = kb.nextInt();
		C = kb.nextInt();
		K = kb.nextInt();
		
		visited = new int[R][C];
		board = new char[R][C];
		for(int i=0; i<R; i++) {
			char[] tmp = kb.next().toCharArray();
			board[i] = tmp;
		}
		visited[R-1][0] = 1;
		main.DFS(R-1,0,1);
		System.out.println(answer);
	}
}