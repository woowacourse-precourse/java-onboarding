package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0);

        Map<Integer, Integer> moneyToIndex = makeConverter();
        
        return answer;
    }

    private static Map<Integer, Integer> makeConverter() {
        Map<Integer, Integer> converter = new HashMap<>();

        // 금액을 key값으로 입력하면 알맞는 인덱스를 return해주는 converter 구현
        List<Integer> tmp = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for(int i = 0; i < tmp.size(); i++) {
            converter.put(tmp.get(i), i);
        }
        return converter;
    }
}
