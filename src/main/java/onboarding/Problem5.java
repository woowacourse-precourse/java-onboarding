package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    // main method for testing purposes
    public static void main(String[] args) {
        System.out.println(solution(50237));
        System.out.println(solution(15000));
    }
    public static List<Integer> solution(int money) {

        Integer[] moneyUnit = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        List<Integer> answer = new ArrayList<>();
        for (Integer integer : moneyUnit) {
            answer.add(money / integer);
            money = money % integer;
        }
        return answer;
    }
}
