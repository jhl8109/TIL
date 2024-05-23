import java.util.*;

class PGM_L2_무인도여행 {
    private static boolean[][] visited;
    private static int n,m;
    public int bfs(String[] maps, int y, int x) {
        int[] ny = {0,1,0,-1};
        int[] nx = {1,0,-1,0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        int sum = 0; 
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            // System.out.println(maps[cur[0]].charAt(cur[1]) -'0');
            sum += maps[cur[0]].charAt(cur[1]) -'0';
            // System.out.println(sum);
            for(int i=0; i<4; i++) {
                int dy = cur[0] + ny[i];
                int dx = cur[1] + nx[i];
                if(dy>=0 && dy<n && dx>=0 && dx<m &&!visited[dy][dx] && maps[dy].charAt(dx) != 'X') {
                    // System.out.println(dy + " , "+dx);
                    q.offer(new int[]{dy,dx});
                    visited[dy][dx] = true;
                }
            }
        }
        return sum;
    }
    public int[] solution(String[] maps) {
        List<Integer> lands = new ArrayList();
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int sum = bfs(maps,i,j);
                    // System.out.println("here : " + sum);
                    lands.add(sum);
                }
            }
        }
        Collections.sort(lands);
        int[] answer = new int[lands.size()];
        for(int i=0; i<lands.size(); i++) {
            answer[i] = lands.get(i);
            System.out.println(lands.get(i));
        }
        if(lands.size() == 0) {
            answer = new int[]{-1};
        }
        return answer;
    }
}