package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] price = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int temp = money;

        for(int i = 0; i < 9; i++) {
            answer.add(money/price[i]);

            money = money % price[i];
        }

        System.out.println("money\tresult");

        System.out.println(temp + "\t\t" + answer);

        return answer;
    }
}
