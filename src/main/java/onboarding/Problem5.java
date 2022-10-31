package onboarding;

import java.util.*;

public class Problem5 {

    private static final List<Integer> keySet = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        Map<Integer, Integer> moneyStore = setMoneyStore();

        int i = 0;
        while (i < keySet.size())
            money = extractUnits(money, keySet.get(i++), moneyStore);

        return valuesToList(moneyStore);
    }

    /**
     * 기능 5.1
     * 금액 money를 화폐 단위 unit로 분류
     */
    public static int extractUnits(int money,int unit, Map<Integer,Integer> store) {
        // money를 화폐 단위인 unit으로 바꿀 수 있는 갯수
        int unitCount = money / unit;;

        if (unitCount > 0) {
            // 화폐단위를 빼내고 남은 money를 반환
            money -= unit * unitCount;

            // unit의 key 값을 unitCount로 변경
            store.replace(unit, unitCount);
        }
        return money;
    }
    // 화폐 단위에 맞게 금액을 저장할 map<단위, 갯수>객체 초기화
    private static Map<Integer, Integer> setMoneyStore() {
        return new HashMap<>(Map.of(
                50000, 0,
                10000, 0,
                5000, 0,
                1000, 0,
                500, 0,
                100, 0,
                50, 0,
                10, 0,
                1, 0
        ));
    }

    // map객체의 values를 keySet순서에 맞는 List로 변환
    public static List<Integer> valuesToList(Map<Integer, Integer> store) {
        List<Integer> unitList = new ArrayList<>();

        int i = 0;
        while(i < keySet.size())
            unitList.add(store.get(keySet.get(i++)));

        return unitList;
    }
}
