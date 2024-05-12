import java.util.*;

class Solution {
    public static List<String> left = new ArrayList<>();
    public static List<String> right = new ArrayList<>();
    public int solution(String str1, String str2) {
        cutTwoStr(str1, str2);
        printList();
        int answer = jaccard(str1,str2);
        return answer;
    }
    public int jaccard(String str1, String str2) {
        Map<String, Integer> cross = new HashMap<>();
        Map<String, Integer> plus = new HashMap<>();
        for(int i=0; i<left.size(); i++) {
            int leftCount = Collections.frequency(left,left.get(i));
            int rightCount = Collections.frequency(right,left.get(i));
            int val = cross.getOrDefault(left.get(i),0); // 저장된 적 없으면
            if (val == 0) {
                cross.put(left.get(i),Math.min(leftCount, rightCount));
                plus.put(left.get(i),Math.max(leftCount, rightCount));
            }
        }
        for(int i=0; i<right.size(); i++) {
            int leftCount = Collections.frequency(left,right.get(i));
            int rightCount = Collections.frequency(right,right.get(i));
            int val = cross.getOrDefault(right.get(i),0); // 저장된 적 없으면
            if (val == 0) {
                cross.put(right.get(i),Math.min(leftCount, rightCount));
                plus.put(right.get(i),Math.max(leftCount, rightCount));
            }
        }
        int crossCnt = 0, plusCnt = 0;
        for(String key : cross.keySet()){
            crossCnt += cross.get(key);
        }
        for(String key : plus.keySet()){
            plusCnt += plus.get(key);
        }
        System.out.printf("%d , %d , %.3f\n",crossCnt, plusCnt, (double)crossCnt/plusCnt * 65536);
        if(plusCnt == 0) return 65536;
        else return (int)((double)crossCnt/plusCnt * 65536);
    }
    public void cutTwoStr(String str1,String str2) {
        // 두글자 끊기
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str1.length()-1; i++) {
            if(!Character.isAlphabetic(str1.charAt(i)) || 
               !Character.isAlphabetic(str1.charAt(i+1))) continue;
            sb.append(str1.charAt(i));
            sb.append(str1.charAt(i+1));
            left.add(sb.toString());
            sb.setLength(0);
        }
        for(int i=0; i<str2.length()-1; i++) {
            if(!Character.isAlphabetic(str2.charAt(i)) || 
               !Character.isAlphabetic(str2.charAt(i+1))) continue;
            sb.append(str2.charAt(i));
            sb.append(str2.charAt(i+1));
            right.add(sb.toString());
            sb.setLength(0);
        }
    }
    public void printList() {
        for (String s : left) {
            System.out.printf("%s, ",s);
        }
        System.out.println();
        for (String s : right) {
            System.out.printf("%s, ",s);
        }
    }
}