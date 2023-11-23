import java.util.*;

class Solution {
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    List<Point> players = new ArrayList<>();
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
    
        for(int x = 0; x < 5; x++) {
            String[] place = places[x];
            for(int i=0; i<5; i++) {
                for(int j=0; j<5; j++) {
                    if(place[i].charAt(j) == 'P') {
                        players.add(new Point(i,j,0));
                    }
                }
            }
            for(Point player : players) {
                int result = checkDist(player,place);
                if(result == 0)
                    answer[x] = result;
            }
            players.clear();
            
        }
        
        
        return answer;
    }
    public static int checkDist(Point p, String[] place) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[5][5];
        q.offer(p);
        isVisited[p.y][p.x] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int dist = cur.dist;
            if(dist <= 2 && dist > 0 && place[y].charAt(x) == 'P') return 0;
            
            for(int i=0; i<4;i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 5 && ny >= 0 && nx < 5 && nx >= 0 && !isVisited[ny][nx] && place[ny].charAt(nx) != 'X'){
                    q.offer(new Point(ny,nx,dist+1));
                    isVisited[ny][nx] = true;
                }
            }
        }
        
        return 1;
    }
}
class Point{
    int y,x,dist;
    
    Point(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}