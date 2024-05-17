import java.io.*;
import java.util.*;

public class BOJ_G5_13023 {
    private static int N,M;
    private static int answer = 0;
    private static List<List<Integer>> friendship = new ArrayList<>();
    // 1. 무한 루프를 조심하자.
    // 2. DFS로 해서 단 5명이 사이클이 있는지
    public static void dfs(int root, int start, int depth, boolean[] visited, StringBuilder s) {
        visited[start] = true;
        s.append(String.valueOf(start));
        if(answer == 1) return;
        if(depth == 5) {
            answer = 1;
            return;
        } else {
            List<Integer> friends = friendship.get(start);
            for(int friend : friends) {
                if(!visited[friend]) dfs(root,friend, depth+1, visited,s);
            }
        } 
        visited[start] = false;
        s.deleteCharAt(s.length()-1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for(int i=0; i<N; i++) {
            List<Integer> empty = new ArrayList<>();
            friendship.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            friendship.get(f1).add(f2);
            friendship.get(f2).add(f1);
        }
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) {
            dfs(i,i,1,visited, new StringBuilder());
        }
        
        System.out.println(answer);
    }
}