import java.util.*;
import java.io.*;



class BOJ_G5_5972{
    public static int dijkstra(int N, ArrayList<ArrayList<Node>> roads) {
        final int START = 1;
        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[N+1];
        Arrays.fill(visited,false);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(START, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            // System.out.println(cur.idx+" , "+cur.cost);
            if(cur.idx == N) {
                min = Math.min(min,cur.cost);
                continue;
            }
            if(visited[cur.idx]) continue;
            else visited[cur.idx] = true;
            
            for(int i=0; i<roads.get(cur.idx).size(); i++) {
                Node next = roads.get(cur.idx).get(i);
                if(!visited[next.idx] && cur.cost+next.cost< min)
                    pq.offer(new Node(next.idx, cur.cost+ next.cost));
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> roads = new ArrayList<>();
        for(int i=0;i<=N; i++){
            roads.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken());
            int bi = Integer.parseInt(st.nextToken());
            int ci = Integer.parseInt(st.nextToken());
            roads.get(ai).add(new Node(bi,ci));
            roads.get(bi).add(new Node(ai,ci));
        }
        
        for(int i=1; i<=N;i++){
            
        }
        System.out.println(dijkstra(N,roads));
    }

    static class Node implements Comparable<Node>{
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
}