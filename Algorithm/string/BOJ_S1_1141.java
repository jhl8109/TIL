import java.util.*;

class BOJ_S1_1141 {
    static int N;
    static String[] words;
    static ArrayList<Integer> prefixes;
    static Set<String> answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        words = new String[N];
        prefixes = new ArrayList<>();
        answer = new HashSet<>();

        for(int i=0; i<N; i++) {
            words[i] = sc.next();
        }
        for(int i=0; i<N; i++) {
            int cnt = 0; // 접두사가 아닌게 N-1이 되어야 접두사 X에 포함됨.
            for(int j=0; j<N; j++) {
                if(i == j) continue;
                else if(words[i].length() < words[j].length()){
                    for(int k=0; k<words[i].length(); k++){
                        if(words[i].charAt(k) != words[j].charAt(k)) {
                            // 접두사 아님
                            cnt++;
                            break;
                        } 
                    }
                } else { // 자기가 접두사가 될 수 없음 아님
                    cnt++;
                }
            }
            if(cnt == N-1) {
                // System.out.println(words[i]);
                answer.add(words[i]);
            }
        }
        System.out.println(answer.size());
    }
}