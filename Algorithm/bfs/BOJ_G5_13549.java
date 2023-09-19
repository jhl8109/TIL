import java.util.*;
import java.io.*;


class Node implements Comparable<Node>{
    int pos;
    int times;

    public Node(int pos, int times) {
        this.pos = pos;
        this.times = times;
    }
    @Override
    public int compareTo(Node o) {
        return this.times - o.times;
    }
}

class BOJ_G5_13549{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();

        pq.offer(new Node(N,0));
        visited.add(N);

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            visited.add(cur.pos);
            if(cur.pos == K) {
                System.out.println(cur.times);
                break;
            }

            if(cur.pos-1 >= 0 && !visited.contains(cur.pos-1)) {
                pq.add(new Node(cur.pos-1, cur.times+1));
            }
            if(cur.pos+1 <= 100000 && !visited.contains(cur.pos+1)) {
                pq.add(new Node(cur.pos+1, cur.times+1));
            }
            if(cur.pos *2 <= 100000 && !visited.contains(cur.pos*2)) {
                pq.add(new Node(cur.pos*2, cur.times));
            }
        }
        

    }
}