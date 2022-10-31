package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
    기능 명세
    1. convert(int money) : 돈을 입력받아 화폐 단위로 바꾸는 함수
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        return convert(money);
    }

    public static List<Integer> convert(int money) {
        List<Integer> result = new ArrayList<>();
        List<Integer> units = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for (int i = 0; i < units.size(); i++) {
            result.add(money / units.get(i));
            money %= units.get(i);
        }
        return result;
    }
}
