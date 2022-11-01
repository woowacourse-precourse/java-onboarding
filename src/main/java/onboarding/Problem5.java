package onboarding;


import java.util.ArrayList;
import java.util.List;

enum Currency {
    KR_WON(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)),
    US_USD(List.of(100, 50, 20, 10, 5, 2, 1));

    private final List<Integer> unitList;

    Currency(List<Integer> unitList) {
        this.unitList = unitList;
    }

    public List<Integer> convert(int money) {
        List<Integer> converted = new ArrayList<>();
        for (Integer unit : unitList) {
            converted.add(money / unit);
            money = money % unit;
        }

        return converted;
    }
}

/*
기능 목록
1. 그리디하게 큰 금액부터 금액 별 개수 저장
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        return Currency.KR_WON.convert(money);
    }
}
