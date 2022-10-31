package onboarding;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Problem5 {

    static class Money {

        final int START_RANGE = 1;
        final int END_RANGE = 1_000_000;


        private int value;

        public int getValue() {
            return value;
        }
        public Money(int value) {
            if (!isValidValue(value)) {
                throw new InputMismatchException("입력된 금액의 크기가 [1,1_000_000] 이내가 아닙니다.");
            }
            this.value = value;
        }

        private boolean isValidValue(int value) {
            return START_RANGE <= value && value <= END_RANGE;
        }

        private boolean isEnough(Money other) {
            return this.getValue() >= other.getValue();
        }

        public List<Integer> diviedAsUnitList() {
            return MONEY_UNIT_LIST.divide(this);
        }
    }

    public static Money makeMoney(int money) {
        return new Money(money);
    }

    static class MoneyUnit extends Money {

        public MoneyUnit(int value) {
            super(value);
        }

        private Money changeMoney(Money money) {
            if (!canChange(money)) {
                throw new RuntimeException("금액이 단위보다 큽니다.");
            }
            if (!isChangeLeft(money)) {
                return null;
            }
            return makeMoney(money.getValue() % this.getValue());
        }

        private int countFor(Money money) {
            return money.getValue() / this.getValue();
        }

        private boolean canChange(Money money) {
            return money != null && money.isEnough(this);
        }

        private boolean isChangeLeft(Money money) {
            if (!this.canChange(money)) {
                throw new RuntimeException("금액이 단위보다 큽니다.");
            }

            return money.getValue() % this.getValue() != 0;

        }
    }


    public static MoneyUnit makeMoneyUnit(int money) {
        return new MoneyUnit(money);
    }

    static class MONEY_UNIT_LIST {

        static final List<MoneyUnit> UNIT_LIST = List.of(
                makeMoneyUnit(50_000),
                makeMoneyUnit(10_000),
                makeMoneyUnit(5_000),
                makeMoneyUnit(1_000),
                makeMoneyUnit(500),
                makeMoneyUnit(100),
                makeMoneyUnit(50),
                makeMoneyUnit(10),
                makeMoneyUnit(1)
        );

        static private List<Integer> divide(Money money) {

            List<Integer> ret = new ArrayList<>();
            Money leftMoney = money;

            for (MoneyUnit unit : UNIT_LIST) {
                if (!unit.canChange(leftMoney)) {
                    ret.add(0);
                    continue;
                }

                ret.add(unit.countFor(leftMoney));

                leftMoney = unit.changeMoney(leftMoney);
            }

            return ret;
        }


    }


    public static List<Integer> solution(int money) {
        return makeMoney(money).diviedAsUnitList();
    }


}
