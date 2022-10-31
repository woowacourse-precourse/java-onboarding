package onboarding;

import onboarding.exception.InputRangeException;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    static final int[] MONETARY_UNIT = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 입력된 금액에 대한 검증을 진행한다.
        checkInputNumber(money);

        // 내림차순으로 정렬된 화폐 단위를 순회한다.
        for(int unit : MONETARY_UNIT) {
            // 기존 금액이 단위보다 작으면 해당 화폐의 개수는 0으로 간주한다.
            if (money < unit) {
                answer.add(0);
                continue;
            }
            // 그게 아니라면 기존 금액에서 화폐 단위로 나눈 몫이 개수가 된다.
            answer.add(money/unit);
            // 기존 금액은 화폐 단위로 나눈 나머지로 갱신한다.
            money %= unit;
        }

        return answer;
    }

    /**
     * 입력 number에 대해 검증을 진행한다.
     *
     * @param number 입력으로 들어온 number
     */
    private static void checkInputNumber(int number) {
        if (number < 1 || number > 1000000) {
            throw new InputRangeException("number는 1~1,000,000 사이여야 합니다.");
        }
    }
}
