package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    /**
     * 올바른 숫자가 입력되었는지 검증합니다.
     * @param number 숫자
     * @return 올바른 숫자라면 TRUE 반환
     */
    private static boolean validateNumber(int number) {
        // 숫자가 1 이상 ~ 10,000 이하 자연수 인지 확인
        return (number >= 1 && number <= 10000);
    }

    /**
     * 숫자 분할하기
     * @param number 숫자
     * @return 분할된 숫자 배열
     */
    private static int[] splitNumber(int number) {
        ArrayList<Integer> arrayNumber = new ArrayList<>();

        while (number > 0) {
            arrayNumber.add(number % 10);
            number /= 10;
        }

        Collections.reverse(arrayNumber);

        return arrayNumber.stream().mapToInt(i -> i).toArray();
    }

}
