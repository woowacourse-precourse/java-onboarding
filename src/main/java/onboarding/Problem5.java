package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        Calculator<Integer, List<Integer>> moneyCalculator
                = new MoneyCalculator();
        moneyCalculator.setVariable(money);

        return moneyCalculator.calculation();
    }

    public enum Money{
        AMOUNT(100_000),
        ONE_TWO(2),
        ONE_FIFTH(5),
        TYPE(9);

        private int value;

        Money(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static class MoneyCalculator implements Calculator<Integer, List<Integer>>{
        private int money;

        @Override
        public void setVariable(Integer money) {
            this.money = money;
        }

        /*
         * 나누는 금액이 1/2와 1/5 순서대로 줄어들고 있다.
         * 몫을 리스트에 저장하고, 나머지를 다음 계산을 위한 돈으로 할당한다.
         * */
        @Override
        public List<Integer> calculation(){
            List<Integer> result = new ArrayList<>();

            int divide = Money.AMOUNT.getValue();
            for(int i = 0; i<Money.TYPE.getValue()-1; i++){
                divide = (i % Money.ONE_TWO.getValue() == 0) ?
                        divide / Money.ONE_TWO.getValue() :
                        divide / Money.ONE_FIFTH.getValue();

                result.add(quotient(divide));
                money = remainder(divide);
            }

            result.add(money);

            return result;
        }

        private int quotient(int divide){
            return this.money/divide;
        }

        private int remainder(int divide){
            return this.money%divide;
        }
    }
}
