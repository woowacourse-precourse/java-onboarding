package onboarding.problem5;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Changes {
    private final Map<Money, Integer> changes = new LinkedHashMap<>();

    public Changes(int price) {
        for (Money money : Money.values()) {
            int moneyUnit = money.unit();
            if (price >= moneyUnit) {
                changes.put(money, changes.getOrDefault(money, 0) + price / moneyUnit);
                price %= moneyUnit;
            }
        }
    }

    public List<Integer> changes() {
        List<Integer> changes = new ArrayList<>();
        for (Money money : Money.values()) {
            changes.add(this.changes.getOrDefault(money, 0));
        }
        return changes;
    }
}
