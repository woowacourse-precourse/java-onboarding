package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    // [오만원, 만원, 오천원, 천원, 오백원, 백원, 오십원, 십원, 일원]
    static List<Integer> purse = new ArrayList<>() {{
        add(50000);
        add(10000);
        add(5000);
        add(1000);
        add(500);
        add(100);
        add(50);
        add(10);
        add(1);
    }};

    public static List<Integer> divideMoney(int money) {
        int remainMount = money;

        List<Integer> result = new ArrayList<>(purse.size());

        for (int i = 0; i < purse.size(); i++) {
            // 결과 값 배열에 각 인덱스를 넣음
            result.add(remainMount / purse.get(i));
            // 배열에 넣은 후 나머지 현재 남은 돈에 반영
            remainMount %= purse.get(i);
        }
        return result;
    }

    public static List<Integer> solution(int money) {
        return divideMoney(money);
    }
}
