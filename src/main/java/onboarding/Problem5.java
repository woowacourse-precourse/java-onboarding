package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    // 화폐의 단위를 담은 리스트
    static List<Integer> moneyList = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        return changeMoney(money);
    }

    // 금액이 큰 순서로 변환해서 리스트에 담는 함수
    public static List<Integer> changeMoney(int money){
        List<Integer> result = new ArrayList<>();

        for(int i=0; i < moneyList.size(); i++){
            result.add(money/moneyList.get(i));
            money %= moneyList.get(i);
        }

        return result;
    }
}
