package onboarding;

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


}
