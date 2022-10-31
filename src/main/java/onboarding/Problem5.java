package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 1. 돈 단위(오만원, 만원, 오천원 등) 리스트를 순회하며 단위 별 반환 개수를 저장하는 기능
 * */
public class Problem5 {

    public static final List<Integer> units = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (Integer unit : units) {
            answer.add(money / unit);
            money = money % unit;
        }
        return answer;
    }
}
