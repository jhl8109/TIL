import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int idx;
    int cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}


class BOJ_G5_1916{


    public static void main(String[] args) throws IOException{
        int N,M;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.valueOf(br.readLine());
        M = Integer.valueOf(br.readLine());
        
        int[] dist = new int[N+1];
        for (int i = 0; i <=N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            graph.get(a).add(new Node(b,c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.valueOf(st.nextToken());
        int end = Integer.valueOf(st.nextToken());

        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[start] = 0;
        q.offer(new Node(start,0));
        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(dist[cur.idx] < cur.cost) { //비용이 더 많이 들면 무시
                continue;
            }

            for(int i=0; i < graph.get(cur.idx).size(); i++) {
                Node next = graph.get(cur.idx).get(i);

                if(dist[next.idx] > cur.cost + next.cost) {
                    dist[next.idx] = cur.cost + next.cost;
                    q.offer(new Node(next.idx, cur.cost + next.cost));
                }
            }
        }

        System.out.println(dist[end]);
        
    }

}