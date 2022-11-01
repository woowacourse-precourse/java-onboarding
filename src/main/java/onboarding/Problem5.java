package onboarding;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0);
        int[] price = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i = 0; i < 9; i++) {
            answer.set(i, money/price[i]);

            money = money % price[i];
        }

        System.out.println("money\tresult");

        System.out.println(money + "\t" + answer);

        return answer;
    }
}
