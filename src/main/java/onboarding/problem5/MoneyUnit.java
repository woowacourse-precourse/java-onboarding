package onboarding.problem5;

import java.util.List;

public enum MoneyUnit {
    KOREA(List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1));

    private List<Integer> moneyUnit;

    MoneyUnit(List<Integer> moneyUnit){
       this.moneyUnit = moneyUnit;
    }

    public List<Integer> getUnit() {
        return moneyUnit;
    }
}
