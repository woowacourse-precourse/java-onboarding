/*
 * 우테코 1주차 프리코스 미션 - 문제 3
 * [https://github.com/gilyeon00/java-onboarding/blob/main/docs/PROBLEM3.md]
 *
 */
package onboarding;
/**
 * checkNum : 전달받은 숫자가 제한사항과 맞는지 체크하는 메서드
 **/

public class Problem3 {

    public static int solution(int number) {
        /* 제한 사항 처리 */
        if (checkNum(number) == 0) {
            return -1;
        }

        int answer = 0;
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
