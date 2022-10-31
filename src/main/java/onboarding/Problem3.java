package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Problem3 {
    public static int solution(int number) {
        if (!validateNumber(number)) {
            return 0;
        }

        return countClap(number);
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
     * 박수 세기
     * @param number 분리된 숫자
     * @return 박수 횟수
     */
    private static int countClap(int number) {
        int countClap = 0;

        // 3,6,9 존재 확인 및 갯수 체크
        for(int i = 1; i <= number; i++) {
            int[] splitNumber = getOneLetterNumbers(i);

            for(int j : splitNumber) {
                if (j == 3 || j == 6 || j == 9) {
                    countClap ++;
                }
            }
        }

        return countClap;
    }

    /**
     * 숫자를 한글자씩 분할
     * @param number 숫자
     * @return 분할된 숫자
     */
    private static int[] getOneLetterNumbers(int number) {
        ArrayList<Integer> arrayNumber = new ArrayList<>();

        while (number > 0) {
            arrayNumber.add(number % 10);
            number /= 10;
        }

        Collections.reverse(arrayNumber);

        return arrayNumber.stream().mapToInt(i -> i).toArray();
    }

}
