package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    /*
     * 기능 요구 사항
     * 1. 돈의 단위가 들어있는 배열 생성
     * */

    private static List<Integer> money_unit() {
        List<Integer> money_unit_list = new ArrayList<>();
        money_unit_list.add(50000);
        money_unit_list.add(10000);
        money_unit_list.add(5000);
        money_unit_list.add(1000);
        money_unit_list.add(500);
        money_unit_list.add(100);
        money_unit_list.add(50);
        money_unit_list.add(10);
        money_unit_list.add(1);
        return money_unit_list;
    }


    /*
     * 기능 요구 사항
     * 2. 기능 요구 사항1에서 만든 배열을 원소를 차례대로 돌면서
     * 현재 금액이 배열의 원소보다 더 크거나 같으면,
     * 해당 원소로 나눠주고 몫을 해당 원소의 인덱스와 교체하고,
     * 현재 금액이 배열의 원소보다 작으면 0을 넣어줌
줌    * */
}
