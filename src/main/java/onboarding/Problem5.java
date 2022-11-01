package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        Money money1 = new Money(money);
        Bill bill = new Bill(money1);
        return bill.countMoneyUnit();
    }

    public static void main(String[] args) {
        int money = 50_237;
        Money money1 = new Money(money);
        Bill bill = new Bill(money1);
        bill.countMoneyUnit();

    }
}

class Money {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 1000000;
    private static final String NOT_ALLOWED_UNDER_MIN_RANGE = "money는 1 이상의 자연수입니다.";
    private static final String NOT_ALLOWED_OVER_MAX_RANGE = "money는 1000000 이하의 자연수입니다.";
    private final int money;

    public Money(int money) {
        validateMoneyRange(money);
        this.money = money;
    }

    private void validateMoneyRange(int money) {
        if (money < MIN_RANGE) {
            throw new IllegalStateException(NOT_ALLOWED_UNDER_MIN_RANGE);
        }
        if (money > MAX_RANGE) {
            throw new IllegalStateException(NOT_ALLOWED_OVER_MAX_RANGE);
        }
    }

    public int changeMoney(Money moneyUnit) {
        return this.money / moneyUnit.money;
    }
    /*
    남은 금액도 money validation 충족하는지 확인하기
     */

    public Money remainderMoney(Money moneyUnit) {
        return new Money(this.money % moneyUnit.money);
    }
}

class Bill {
    private Money amountMoney;
    private List<Integer> moneyUnitByMoneyAmount;
    private static final Money FIFTY_THOUSAND = new Money(50000);
    private static final Money TEN_THOUSAND = new Money(10000);
    private static final Money FIVE_THOUSAND = new Money(5000);
    private static final Money ONE_THOUSAND = new Money(1000);
    private static final Money FIVE_HUNDRED = new Money(500);
    private static final Money ONE_HUNDRED = new Money(100);
    private static final Money FIFTY = new Money(50);
    private static final Money TEN = new Money(10);
    private static final Money ONE = new Money(1);

    private List<Money> moneyUnitArray = List.of(FIFTY_THOUSAND, TEN_THOUSAND, FIVE_THOUSAND,
            ONE_THOUSAND, FIVE_HUNDRED, ONE_HUNDRED, FIFTY, TEN, ONE);

    public Bill(Money money) {
        amountMoney = money;
        moneyUnitByMoneyAmount = new ArrayList<>();
    }

    public int countMoneyUnit(int moneyUnitArrayIndex) {
        return amountMoney.changeMoney(moneyUnitArray.get(moneyUnitArrayIndex));

    }

    public Money remainderMoney(int moneyUnitArrayIndex) {
        return amountMoney.remainderMoney(moneyUnitArray.get(moneyUnitArrayIndex));

    }

    public List<Integer> addMoneyUnitByMoneyAmount() {
        for (int i = 0; i < moneyUnitArray.size(); i++) {
            moneyUnitByMoneyAmount.add(countMoneyUnit(i));
            if (i != 7) {
                this.amountMoney = remainderMoney(i);
            }
        }
        return moneyUnitByMoneyAmount;
    }
}

