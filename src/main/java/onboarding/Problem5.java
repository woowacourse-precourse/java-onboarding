package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private final static List<Integer> moneyUnitList = List.of(
            50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1
    );

    public static List<Integer> solution(int money) {
        /* [요구] 돈을 큰 금액의 화폐 위주로 변환한다. */
        return reverMoneyToUnit(money);
    }

    // 돈을 큰 금액의 화폐 위주로 변환하는 함수
    public static List<Integer> reverMoneyToUnit(int money) {
        // 금액이 큰 순서대로 리스트/배열에 담기
        List<Integer> answer = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));
        int index = 0;
        for (int unit : moneyUnitList) {
            if (money >= unit) {
                answer.set(index, (int) money / unit);
                money -= ((int) money / unit) * unit;
            }
            index++;
        }
        return answer;
    }
}
