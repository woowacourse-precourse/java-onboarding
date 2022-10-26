package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 숫자 검증
     * @param money 숫자
     * @return 검증 결과 값
     */
    private static boolean validateMoney(int money) {
        return (money > 0 && money <= 1_000_000);
    }


}
