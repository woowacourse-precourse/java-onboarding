package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer =changeMoney(money);
        return answer;
    }
    public static List<Integer> changeMoney(int money){
        List<Integer> result = new ArrayList<>();
        //오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
        List<Integer> moneyValue = List.of(50000,10000,5000,1000,500,100,50,10,1);
        for (int value:
             moneyValue) {
            result.add(money/value);
            money=money%value;
        }

        return result;
    }
}
