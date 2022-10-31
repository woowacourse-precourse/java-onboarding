package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class Atm {

    private final ChangesList changesList;

    public Atm(ChangesList changesList) {
        this.changesList = changesList;
    }

    public List<Integer> withdraw(int money) {
        return getChanges(money);
    }

    private List<Integer> getChanges(int money) {
        List<Integer> amounts = new ArrayList<>();
        List<Integer> changes = changesList.getChangesList();

        for (Integer change : changes) {
            int count = money / change;

            amounts.add(count);
            money -= (change * count);
        }

        return amounts;
    }

}
