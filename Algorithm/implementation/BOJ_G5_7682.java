import java.util.*;
import java.io.*;

class BOJ_G5_7682{
    public static char[][] map = new char[3][3];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            int xCnt = 0;
            int oCnt = 0;
            int dotCnt = 0;
            String input = br.readLine();
            if(input.equals("end")) break;
            for(int i=0; i<3; i++){
                for(int j=0;j<3;j++){
                    map[i][j] = input.charAt(i*3+j);
                    if(map[i][j] == 'X') xCnt++;
                    if(map[i][j] == 'O') oCnt++;
                    if(map[i][j] == '.') dotCnt++;
                }
            }      
            //게임판이 꽉 채워졌을 때
			//X가 먼저 말을 놓았음으로 O보다 1개 무조건 많아야 한다.
			if(oCnt+xCnt==9 && xCnt-oCnt==1) {
				//한 명이 빙고를 완성하면 게임이 끝나기 때문에
                //둘 다 빙고가 성립될 수 없다.
				if(checkTicTakTo('X') && checkTicTakTo('O')) bw.write("invalid\n");
				//말이 꽉 채워진 경우에는 O가 이길 수 없다
				else if(checkTicTakTo('O')) bw.write("invalid\n");
				//X가 이긴 경우
				else bw.write("valid\n");
			}else{ //게임판이 꽉 채워지지 않은 경우
				//위와 동일하게 한 명이 빙고가 되면 
                //끝나야해서 둘 다 빙고인 경우는 없다.
				if(checkTicTakTo('X') && checkTicTakTo('O')) bw.write("invalid\n");
				//X가 이겼을 땐, X가 선공이어서 무조건 O보다 하나 많아야 한다.
				else if(checkTicTakTo('X') && xCnt-oCnt==1) bw.write("valid\n");
				//O가 이겼을 땐, O가 후공이어서 X와 O의 크기가 같아야만 한다.
				else if(checkTicTakTo('O') && xCnt==oCnt) bw.write("valid\n");
				//아무도 이기지 않았는데 말이 다 채워지지 않는 경우는 불가능하다.
				else bw.write("invalid\n");
			}
            bw.flush();
        }
        

    }
    public static boolean checkTicTakTo(char target){
        for(int i=0; i<3; i++) {
            if(target == map[i][0] && map[i][0] == map[i][1] && map[i][1] == map[i][2]) return true;
            if(target == map[0][i] && map[0][i] == map[1][i] && map[1][i] == map[2][i]) return true;
        }
        if(target == map[0][0] && map[0][0] == map[1][1] && map[1][1] == map[2][2]) return true;
        if(target == map[0][2] && map[0][2] == map[1][1] && map[1][1] == map[2][0]) return true;
        return false;
    }
    public static void printMap(char[][] map){
        for(int i=0; i<3; i++) 
            System.out.println(Arrays.toString(map[i]));
        System.out.println("====================");
    }
}