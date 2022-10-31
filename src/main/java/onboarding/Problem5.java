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

    /*
     * 입력이 유효한지 판별합니다.
     *
     * @param 입력으로 주어진 정수입니다.
     * @return 정수 입력이 유효하다면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidInput(int money) {
        boolean valid = isInRange(money);
        return valid;
    }

    /*
     * 입력의 범위가 유효한지 검사합니다.
     *
     * @param 입력으로 주어진 정수입니다.
     * @return 정수의 값이 1 ~ 1000000 이내라면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isInRange(int number) {
        boolean valid = number > 0 &&
                number <= 1000000;
        return valid;
    }

    /*
     * 금액을 지폐로 교환합니다.
     *
     * @param 지폐로 교환할 액수입니다.
     * @return 교환된 지폐의 장수 배열입니다.
     * */
    private static List<Integer> exchangeMoney(int money) {
        List<Integer> result = new ArrayList<>();

        for (int moneySize: moneys) {
            result.add(money / moneySize);
            money %= moneySize;
        }
        return result;
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
