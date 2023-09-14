import java.util.*;
import java.io.*;

class BOJ_S1_5014{
    public static int F,S,G,U,D; //건물 높이 , 시작, 목표, 윗칸, 아랫칸
    public static Queue<int[]> q = new LinkedList<>();

    public static int solution(int start) {
        int answer = -1;
        boolean[] visited = new boolean[F+1];

        q.add(new int[] {0,start});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int times = cur[0];
            int pos = cur[1];
            if(pos == G) return times;
            else {
                if(pos+U <= F && !visited[pos+U]) {
                    q.offer(new int[] {times+1, pos+U});
                    visited[pos+U] = true;
                } if (pos-D >= 1 && !visited[pos-D]) {
                    q.offer(new int[] {times+1, pos-D});
                    visited[pos-D] = true;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();
        int answer = solution(S);
        if(answer == -1) System.out.println("use the stairs");
        else System.out.println(answer);

        sc.close();
    }
}