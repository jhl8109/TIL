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
	static int N,M,K,blue,white;
	static int[] answer ={0,0};
	static int blueDist, whiteDist;
	static char[][] board;
	static int[][] visited;
	static Queue<int[]> q;
	public void BFS(int y, int x){
		int[] dy = {-1,0,1,0};
		int[] dx = {0,1,0,-1};
		q.offer(new int[] {y,x});
		visited[y][x] = 1;
		// System.out.println(String.valueOf(y) + ":" + String.valueOf(x));
		if(board[y][x] == 'W') white++;
		else blue++;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];

			for(int i=0; i<4; i++) {
				int ny = curY+dy[i];
				int nx = curX+dx[i];
				if(ny <= M-1 && ny>=0 && nx<=N-1 && nx>=0 && visited[ny][nx]==0 &&board[curY][curX] == board[ny][nx]){
					q.offer(new int[] {ny,nx});
					visited[ny][nx] = 1;
					if(board[ny][nx] == 'W') white++;
					else blue++;
				}
			}
		}
	}
	public static void main(String[] args){
		Main main = new Main();
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		visited = new int[M][N];
		board = new char[M][N];
		q = new LinkedList<>();
		for(int i=0; i<M; i++) {
			char[] tmp = kb.next().toCharArray();
			board[i] = tmp;
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				blue=0;
				white=0;
				if(visited[i][j] == 0) {
					main.BFS(i,j);
					// System.out.println(white + " "+ blue);
					answer[0] += white*white;
					answer[1] += blue*blue;
					
				}
			}
		}
		System.out.println(answer[0] + " "+ answer[1]);
	}
}