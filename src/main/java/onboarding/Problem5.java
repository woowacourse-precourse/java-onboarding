package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    // 규칙에 맞게 돈을 반환하는 함수
    private static List<Integer> moneyChange(int money, List<Integer> list) {

        int change = 0;

        if(money/50000 != 0) {
            change = money/50000;
            list.set(0, change);
            money = money%50000;
        }
        if(money/10000 != 0) {
            change = money/10000;
            list.set(1, change);
            money = money%10000;
        }
        if(money/5000 != 0) {
            change = money/5000;
            list.set(2, change);
            money = money%5000;
        }
        if(money/1000 != 0) {
            change = money/1000;
            list.set(3, change);
            money = money%1000;
        }
        if(money/500 != 0) {
            change = money/500;
            list.set(4, change);
            money = money%500;
        }
        if(money/100 != 0) {
            change = money/100;
            list.set(5, change);
            money = money%100;
        }
        if(money/50 != 0) {
            change = money/50;
            list.set(6, change);
            money = money%50;
        }
        if(money/10 != 0) {
            change = money/10;
            list.set(7, change);
            money = money%10;
        }
        if(money/1 != 0) {
            change = money / 1;
            list.set(8, change);
            money = money % 1;
        }

        return list;
    }

    // 리스트 0 으로 초기화
    private static List<Integer> initList(List<Integer> list) {
        list = new ArrayList<>();
        for(int i = 0; i<9; i++) {
            list.add(0);
        }
        return list;
    }
}
