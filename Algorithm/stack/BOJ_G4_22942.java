import java.io.*;
import java.util.*;

public class BOJ_G4_22942 {
    private static int N;

    // x, r 로 어떻게 답을 도출할 것인가?
    // 영역으로 계산 => 어차피 y는 동일,,  처음, 끝으로 확인?=> 스택?
    // 괄호 닫기 문제 처럼? 스택에서 pop 했는데 자기 자신 값이 아닌 다른 값이 나오면 문제가 됨!
    // 시작과 끝 stack을 분리해야할듯, 그리고 다 정렬되어 있어야할듯? 그럼 스택일 필요가..
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList();;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arr.add(x-r);
            arr.add(x+r);
            int exist = map.getOrDefault(x-r,Integer.MIN_VALUE);
            if(exist != Integer.MIN_VALUE) {
                System.out.println("NO");
                return;
            } else {
                map.put(x-r,x+r);
            }
        }
        Collections.sort(arr);
        for(int i=0; i<arr.size(); i++) {
            // System.out.print(arr.get(i) + " "); 
        }
        // System.out.println();
        Stack<Integer> s = new Stack<>();
        int before = Integer.MIN_VALUE;
        for(int i=0; i<arr.size(); i++) {
            int value = arr.get(i);

            if(before == value) {
                System.out.println("NO");
                return;
            } else before = value;
            
            // System.out.println("cur : "+value);
            int check = map.getOrDefault(value, Integer.MIN_VALUE);
            if(check != Integer.MIN_VALUE) { // start이면
                s.add(value);
            } else { // end이면
                int start = s.pop();
                int candidate = map.getOrDefault(start, Integer.MIN_VALUE);
                if(candidate != value) {
                    // System.out.println(candidate);
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}