package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        /* number 값 까지 반복하는 for문 구현 */
        for (int i = 3; i <= number; i++) {
            /* 임시변수 */
            int temp = i;

            /* 각 자리수에 3,6,9라는 숫자가 있을시 횟수 계산 기능 */
            while (temp > 0) {
                if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9) answer++;
                temp /= 10;
            }

        }

        return answer;
    }
}
