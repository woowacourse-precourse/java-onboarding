package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    private final List<Integer> moneys = List.of (
            50000,
            10000,
            5000,
            1000,
            500,
            100,
            50,
            10,
            1
    );

    private static boolean isValidInput(int money) {

        return false;
    }

    private static List<Integer> exchangeMoney(int money) {

        return Collections.emptyList();
    }

    /*
     * Problem5의 솔루션 코드입니다.
     *
     * @param 지폐로 바꿀 액수입니다.
     * @return 교환할 지폐의 배열입니다.
     * */
    public static List<Integer> solution(int money) {
        if (isValidInput(money) == false) {
            return Collections.emptyList();
        }
        List<Integer> answer = exchangeMoney(money);
        return answer;
    }
}
