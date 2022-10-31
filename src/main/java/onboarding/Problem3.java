/*
 * 우테코 1주차 프리코스 미션 - 문제 3
 * [https://github.com/gilyeon00/java-onboarding/blob/main/docs/PROBLEM3.md]
 *
 */
package onboarding;

public class Problem3 {

    public static int solution(int number) {
        /* 제한 사항 처리 */
        if (checkNum(number) == 0) {
            return -1;
        }

        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int num = i;
            /* 맨 마지막 자리 숫자 확인 후, 3/6/9일 경우 answer증가 */
            while (num != 0) {
                int divideNum = (num % 10);
                if (divideNum != 0 && divideNum % 3 == 0) {
                    answer++;
                }
                num /= 10;
            }
        }

        return answer;
    }

    private static int checkNum(int number) {
        /* number가 1이상 10,000이하인지 확인 */
        if (number < 1 || number > 10000){
            return 0;
        }
        return number;
    }
}
