package onboarding;
import java.util.Scanner;
public class Problem3 {
    public static int solution(int number) {
        int[] num = new int[number]; // 1부터 입력 받은 숫자를 담을 배열 선언, 생성하기
        for (int i=0; i<number; i++) { //1부터 입력 받은 숫자까지로 배열 초기화
            num[i] = i+1;
        }
        int tmp = 0;
        int answer = 0;

        for(int i=0; i<number; i++) {
            int length = Integer.toString(i).length(); //자리수
            while (length > 0) { //최소 한자리 수
                if (length == 1) { // 한자리 수일 때
                    if (num[i] == 3 || num[i] == 6 || num[i] == 9) {
                        answer += 1;
                    }
                    length--;
                } else { // 두자리 수 이상일 때
                    tmp = (int) (num[i] / (Math.pow(10, length-1))); //가장 높은 자리수에 3||6||9가 들어가는지 확인
                    if (tmp == 3 || tmp == 6 || tmp == 9) {
                        answer += 1;
                    }
                    num[i] = (int) (num[i] - (tmp * (Math.pow(10, length-1)))); //자리수 낮추기
                    length--;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) { //숫자 입력 받기
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(solution(number));
    }
}
