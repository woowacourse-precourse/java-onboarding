package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    // 사용되는 화폐 단위를 담은 int형 Array
    private static final int[] moneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    /**
     * 남은 금액 중에서 선택할 수 있는 가장 큰 화폐 단위를 선택하고, 해당 금액만큼을 차감하는 메소드
     * @param remainingPrice
     * @return
     */
    private static List<Integer> exposeCashUnit(int remainingPrice) {
        int unit = 0;

        for (; unit < moneyUnit.length; unit++) {
            if (remainingPrice >= moneyUnit[unit]) {
                remainingPrice -= moneyUnit[unit];
                break;
            }
        }

        List<Integer> answer = new ArrayList<>();
        answer.add(remainingPrice);
        answer.add(unit);
        return answer;
    }

    /**
     * 넘겨받은 money를 각 화폐 단위로 나누어 리턴한다.
     * @param money
     * @return
     */
    private static List<Integer> getEachUnit(int money) {

        Integer[] unitCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        while (money > 0) {
            List<Integer> tempResult = exposeCashUnit(money);
            money = tempResult.get(0);
            unitCount[tempResult.get(1)]++;
        }

        List<Integer> result = Arrays.asList(unitCount);
        return result;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = getEachUnit(money);
        return answer;
    }
}
