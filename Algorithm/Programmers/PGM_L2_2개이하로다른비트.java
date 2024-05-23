class PGM_L2_2개이하로다른비트  {
    // 우측에 1~2개의 빈자리가 있다? 그럼 우측을 노려라
    // 우측에 1~2개의 빈자리가 없다..? => 111형태면 그럼 좌측 하나는 고정이다 1011 원래 자리 제일 좌측 비트만 0으로 바꾸면 됨.
    // => String으로 바꾸고, 우측부터 순회해서 0을 찾는다.
    // => 0이 하나도 없으면 공식대로 감 사이즈 만큼 111111... 로 바꾸고 원래 String크기의 2^을 뺌
    // => 0이 하나라도 있으면 제일 먼저 만난 0을 1로 바꾸고 계산
    // 110 => 
    // 9 : 1001 => 4 : 100 => 2: 10 => 1 : 1
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int x=0; x<numbers.length; x++) {
            long num = numbers[x];
            StringBuilder sb = new StringBuilder();
            while(num != 0) {
                sb.append(String.valueOf(num%2));
                num /= 2;
            }
            // sb 는 뒤집어져 있음. 즉 왼쪽부터 확인하면 됨!
            String bit = sb.toString();
            int zero = -1;
            int one = -1;
            long sum = 0;
            for(int i=0; i<bit.length(); i++) { // 가장 낮은 0 구하기
                if(bit.charAt(i) == '0' && zero == -1) {
                    zero = i;   
                    sum+= Math.pow(2,i);
                } else if(bit.charAt(i) == '1') {
                    sum+= Math.pow(2,i);                    
                }
            }
            for(int i=zero; i>=0; i--) { // zero보다 낮은 1 구하기
                if(bit.charAt(i) == '1') {
                    one = i;
                    sum -= Math.pow(2,one);
                    break;
                }
            }
            if(zero == -1) {
                long lastBit = bit.length()-1;
                long value = (long)Math.pow(2,lastBit);
                sum =  (long)Math.pow(2,lastBit+2)-1 -(long)Math.pow(2,lastBit);
            } 
            answer[x] = sum;
        }
        
        return answer;
    }
}