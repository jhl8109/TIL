import java.util.*;
import java.io.*;

public class BOJ_G5_20055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] belt = new int[n*2 + 1];
        boolean[] robots = new boolean[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n*2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        //단계
        int answer = 1;

        while(true) {
            //1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.

            //벨트를 한칸씩 옮긴다.
            int temp = belt[n*2];

            for(int i = n*2; i > 1; i--) {
                belt[i] = belt[i-1];
            }

            belt[1] = temp;

            //로봇의 위치를 한칸씩 옮긴다.
            for (int i = n; i > 1; i--) {
                robots[i] = robots[i-1];
            }

            robots[1] = false;

            //내리는 위치에 로봇이 있으면 내린다.
            if(robots[n]) {
                robots[n] = false;
            }

            //2.가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다

            //2-1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있으면 로봇을 한칸 옮긴다.
            for (int i = n-1; i > 0; i--) {
                if (robots[i] && !robots[i+1] && belt[i+1] >= 1) {
                    belt[i+1]--;
                    robots[i] = false;
                    robots[i+1] = true;
                }
            }

            //내리는 위치에 로봇이 있으면 내린다.
            if(robots[n]) {
                robots[n] = false;
            }

            //3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if(belt[1] > 0) {
                robots[1] = true;
                belt[1]--;
            }

            //4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            int zeroCount = 0;
            for (int i = 1; i <= n * 2; i++) {
                if (belt[i] == 0) {
                    zeroCount++;
                }

                if (zeroCount >= k) {
                    System.out.println(answer);
                    return;
                }
            }

            answer++;
        }
    }
}