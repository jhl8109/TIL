import java.util.*;

class BOJ_S3_15649{
    static int N,M;

    public void dfs(int start, ArrayList<Integer> arr) {
        if(arr.size() == M){
            for(int x : arr)
                System.out.print(x + " ");
            System.out.println();
        }
            
        for(int i=1; i<=N; i++) {
            if(arr.contains(i)) continue;
            arr.add(i);
            if(arr.size() == M) {
                for(int x : arr)
                    System.out.print(x + " ");
                System.out.println();
                arr.remove(arr.size()-1);
            }
            else {
                dfs(i,arr);
                arr.remove(arr.size()-1);
            }
            
        }
    }
    public static void main(String[] args) {
        BOJ_S3_15649 main = new BOJ_S3_15649();
        
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        M =sc.nextInt();
        ArrayList<Integer >arr = new ArrayList<>();
        for(int i =1; i<=N; i++) {
            arr.add(i);
            main.dfs(i,arr);
            arr.clear();
        }
    }
}