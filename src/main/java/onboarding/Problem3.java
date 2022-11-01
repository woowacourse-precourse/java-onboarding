/*
 * Problem3.java
 *
 * 2022-10-29
 *
 */
package onboarding;

/**
 * 우아한 테크코스 - 프리코스 1주차 369 게임
 *
 * @author 이준현
 * @version 1.00 2022년 10월 29일
 */
public class Problem3 {

    /**
     * 입력받은 Number가 문제의 제시조건에 부합하는지 유효성 검사
     *
     * @param number input으로 입력받은 number
     * @return number가 1과 10000 사이의 값인지 여부
     */
    public static boolean validCheck(int number) {
        return number >= 1 && number <= 10000;
    }

    /**
     * 1~number까지 각 자리수가 3,6,9의 빈도수를 찾는 method
     *
     * @param number 3,6,9의 빈도를 측정할 최대값
     * @return 3, 6, 9의 빈도수
     */
    public static int countClap(int number) {
        int cnt = 0;
        int lastNumber;
        for (int i = 0; i <= number; i++) {
            int temp = i;
            while (temp != 0) {
                lastNumber = temp % 10;
                if (lastNumber == 3 || lastNumber == 6 || lastNumber == 9) {
                    cnt++;
                }
                temp /= 10;
            }
        }
        return cnt;
    }

    /**
     * 1부터 number까지 측정된 3,6,9의 빈도수를 return
     *
     * @param number 정답을 도출할 수의 최대값
     * @return 3, 6, 9의 빈도수
     */
    public static int solution(int number) {
        if (!validCheck(number)) {
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        int answer = 0;
        answer = countClap(number);
        return answer;
    }
}
