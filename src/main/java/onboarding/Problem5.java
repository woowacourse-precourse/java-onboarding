/*
 *기능목록
 * 1. 화폐 단위 저장하는 함수
 * 2. 나누기한 값 return하는 함수
 * 3. 나누기한 나머지 값 return하는 함수
 */
package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyUnits = new ArrayList<>();
        moneyUnitAdd(moneyUnits);
        for (int unit : moneyUnits) {
            answer.add(moneyConvertIntoUnit(money, unit));
            money = moneyChangeAfterConvert(money, unit);
        }
        return answer;
    }

    public static void moneyUnitAdd(List<Integer> moneyUnits) {
        moneyUnits.add(50000);
        moneyUnits.add(10000);
        moneyUnits.add(5000);
        moneyUnits.add(1000);
        moneyUnits.add(500);
        moneyUnits.add(100);
        moneyUnits.add(50);
        moneyUnits.add(10);
        moneyUnits.add(1);
    }

    public static int moneyConvertIntoUnit(int money, int unit) {
        return money / unit;
    }

    public static int moneyChangeAfterConvert(int money, int unit) {
        return money % unit;
    }
}
