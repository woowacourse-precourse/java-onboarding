package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoneyChanger {
    private final List<Integer> changedList = new ArrayList<>();
    private final List<Integer> wonList = Stream.of(Won.values()).map(Won::getMoney).collect(Collectors.toList());

    public void changeMoney(int money) {
        for (Integer currencyUnit : wonList) {
            changedList.add(money / currencyUnit);
            money %= currencyUnit;
        }
    }

    public List<Integer> getChangedList() {
        return changedList;
    }
}
