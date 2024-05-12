import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G5_20437 {
    public static String W;
    public static int K, T;

    public static void solution(char[] word, int k) {
        // 각 문자별 위치를 저장할 맵
        Map<Character, List<Integer>> positionMap = new HashMap<>();
        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            positionMap.putIfAbsent(c, new ArrayList<>());
            positionMap.get(c).add(i);
        }

        int minimumLength = Integer.MAX_VALUE;
        int maximumLength = -1;

        for (Map.Entry<Character, List<Integer>> entry : positionMap.entrySet()) {
            List<Integer> positions = entry.getValue();
            if (positions.size() >= k) {
                // K개이상 문자를 가지고 있는 인덱스들을 확인
                for (int i = 0; i <= positions.size() - k; i++) {
                    int start = positions.get(i);
                    int end = positions.get(i + k - 1);
                    int length = end - start + 1;

                    minimumLength = Math.min(minimumLength, length);

                    if (word[start] == word[end]) {  // 첫 글자와 마지막 글자가 같을 경우
                        maximumLength = Math.max(maximumLength, length);
                    }
                }
            }
        }

        if (minimumLength == Integer.MAX_VALUE || maximumLength == -1) {
            System.out.println(-1);
        } else {
            System.out.println(minimumLength + " " + maximumLength);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            W = br.readLine().trim();
            K = Integer.parseInt(br.readLine().trim());
            solution(W.toCharArray(), K);
        }
    }
}