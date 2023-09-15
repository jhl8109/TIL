class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = {};
        answer = new int[balls.length];
        
        
        for(int i=0; i<balls.length; i++) {
            int tmp=0, tmp1=0, tmp2=0;
            int cal = Integer.MAX_VALUE;
            
            tmp1 = (int)Math.pow(Math.abs(balls[i][0] - startX),2);// 가로값
            //위
            if(startX == balls[i][0] && balls[i][1] > startY){
                ;
            } else {
                tmp2 = (int)Math.pow(n-startY +n-balls[i][1] ,2);
                tmp = tmp1+tmp2;
                cal = Math.min(cal,tmp);
                // System.out.println("up - "+"tmp1 : " + tmp1 + ", tmp2 : " + tmp2);
            }
            //아래
            if(startX == balls[i][0] && balls[i][1] < startY){
                ;
            } else {
                tmp2 = (int)Math.pow(startY+balls[i][1],2);
                tmp = tmp1+tmp2;
                cal = Math.min(cal,tmp);
                // System.out.println("down - "+"tmp1 : " + tmp1 + ", tmp2 : " + tmp2);  
            }
            
              
            
            tmp1 = (int)Math.pow(Math.abs(balls[i][1]-startY),2);// 세로값
            //오른쪽
            if(startY == balls[i][1] && balls[i][0] > startX){
                ;
            } else {
                tmp2 = (int)Math.pow(m-startX + m-balls[i][0],2);
                tmp = tmp1+tmp2;
                cal = Math.min(cal,tmp);
                // System.out.println("right - "+"tmp1 : " + tmp1 + ", tmp2 : " + tmp2);
            }
            //왼쪽
            if(startY == balls[i][1] && balls[i][0] < startX){
                ;
            } else {
                tmp2 = (int)Math.pow(startX + balls[i][0],2);
                tmp = tmp1+tmp2;
                cal = Math.min(cal,tmp);
                // System.out.println("left - "+"tmp1 : " + tmp1 + ", tmp2 : " + tmp2);
            }
                       
            answer[i] = cal;
            // System.out.println(cal);
        }
        
        return answer;
    }
}