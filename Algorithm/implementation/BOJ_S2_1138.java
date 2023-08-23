import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) { //현재번호
            int left = kb.nextInt(); // 왼 쪽에 키큰 사람 수
            for (int j = 1; j <= n; j++) {//배치할번호
                if (left == 0 && arr[j] == 0) { //left 수를 맞췄고, 해당 자리가 비어 있으면
                    arr[j] = i; // 자리배치
                    break;
                } else if (arr[j] == 0) { //비어있음(큰사람 하나 추가)
                    left--;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}