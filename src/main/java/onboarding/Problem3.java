package onboarding;

/**
 * 기능 1: 1부터 n까지 숫자를 증가시켜 가며 각 자릿수을 뽑아서 박수 횟수 카운트하기
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int num = i;

            while(num != 0) {
                if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                    answer++;
                }
                num /= 10;
            }
        }
        return answer;
    }
}
