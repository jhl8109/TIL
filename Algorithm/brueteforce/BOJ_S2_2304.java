import java.util.*;
import java.io.*;

public class BOJ_S2_2304 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] pillar = new int[N][2];
		int tall = 0;
		
		for(int n = 0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pillar[n][0] = Integer.parseInt(st.nextToken());
			pillar[n][1] = Integer.parseInt(st.nextToken());
			
			tall = Math.max(pillar[n][1], tall);
		}
		
		Arrays.sort(pillar, (o1,o2) -> {
			return o1[0]-o2[0];
		});
		 
		int start = 0;
		for(int i = 0; i<N; i++) {
			if(pillar[i][1]==tall) start = i;
		}
		int size = tall;
		
		int prevX = pillar[0][0];
		int prevH = pillar[0][1];
		
		//왼쪽 탐색
		for(int i = 0; i<=start; i++) {
			if(pillar[i][1] >= prevH) {
				size += (pillar[i][0]-prevX)*prevH;
				//현재 기둥 정보 갱신
				prevX = pillar[i][0];
				prevH = pillar[i][1];
			}
		}
		
		//마지막 기둥
		prevX = pillar[N-1][0];
		prevH = pillar[N-1][1];
		
		//오른쪽 탐색
		for(int i = N-1; i>=start; i--) {
			if(pillar[i][1] >= prevH) {
				size += (prevX - pillar[i][0])*prevH;
				//현재 기둥 정보 갱신
				prevX = pillar[i][0];
				prevH = pillar[i][1];
			}
		}
		System.out.println(size);
		
	}

}