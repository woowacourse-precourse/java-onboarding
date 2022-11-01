package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = exchangeList(money);
        return answer;
    }
    private static List<Integer> exchangeList(int input){
        List<Integer> result = new ArrayList<>();
        List<Integer> moneyUnit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for(int i : moneyUnit){
            result.add(input/i);
            input = input % i;
        }
        return result;
    }
}
