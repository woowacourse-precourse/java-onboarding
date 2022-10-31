package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final List<Integer> moneys = List.of (
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

    /**
     * 금액을 화폐로 교환합니다.
     *
     * @param money 화폐로 교환할 액수를 표현한 정수입니다.
     * @return 교환된 화폐의 장수 배열입니다.
     * */
    private static List<Integer> exchangeMoney(int money) {
        List<Integer> result = new ArrayList<>();

        for (int moneySize: moneys) {
            result.add(money / moneySize);
            money %= moneySize;
        }
        return result;
    }

    /**
     * Problem5의 솔루션 코드입니다.
     *
     * @param money 화폐로 바꿀 액수입니다.
     * @return 교환된 화폐의 배열입니다.
     * */
    public static List<Integer> solution(int money) {
        List<Integer> answer = exchangeMoney(money);
        return answer;
    }
}
