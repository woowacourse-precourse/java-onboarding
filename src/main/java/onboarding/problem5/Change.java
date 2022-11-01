package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class Change {

    int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    List<Integer> changes = new ArrayList<>();

    // 금액이 큰 순서대로 환전해서 화폐 개수만큼 리스트에 넣기
    public List<Integer> getChanges(int money) {

        Money.validate(money);

        for (int unit : units) {
            changes.add(money/unit);
            money = money % unit;
        }
        return changes;
    }

}
