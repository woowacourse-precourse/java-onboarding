package onboarding.problem5.objects;

import java.util.ArrayList;
import java.util.List;

public class MoneyUnitCounter {

    private List<Integer> units = new ArrayList<>() {{
        add(50000);
        add(10000);
        add(5000);
        add(1000);
        add(500);
        add(100);
        add(50);
        add(10);
        add(1);
    }};

    public List<Integer> getUnitCounts(int money) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < units.size(); i++) {
            int count = money / units.get(i);
            result.add(count);
            money %= units.get(i);
        }

        return result;
    }
}
