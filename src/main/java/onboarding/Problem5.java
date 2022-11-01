package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final int MIN_MONEY_UNIT = 1;
    static final int MAX_MONEY_UNIT = 1000000;

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int currMoney = money;

        MoneyUnits moneyUnits = new MoneyUnits(
                List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        List<Integer> moneyUnitList = moneyUnits.getMoneyUnits();

        for(int unit : moneyUnitList){
            answer.add(currMoney / unit);
            currMoney %= unit;
        }
        return answer;
    }

    // 일급 컬렉션 적용
    static class MoneyUnits{
        List<Integer> moneyUnits = new ArrayList<>();

        public MoneyUnits(List<Integer> moneyUnits){
            validateMoneyUnitSize(moneyUnits);
            this.moneyUnits = moneyUnits;
        }

        // 이후 화폐 단위 추가 가능성을 고려합니다.
        public void addMoneyUnit(int moneyUnit){
            this.moneyUnits.add(moneyUnit);
        }

        public List<Integer> getMoneyUnits() {
            return moneyUnits;
        }

        public void validateMoneyUnitSize(List<Integer> moneyUnits){
            for(int moneyUnit : moneyUnits){
                if(moneyUnit < MIN_MONEY_UNIT || moneyUnit > MAX_MONEY_UNIT){
                    throw new IllegalArgumentException(moneyUnit + "가 제한사항 돈의 액수 범위를 벗어납니다.");
                }
            }
        }
    }
}
