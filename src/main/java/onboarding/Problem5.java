package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        return calMoneys(money);
    }

    private static List<Integer> makeMoneys(){
        return List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    }

    private static List<Integer> calMoneys(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneys = makeMoneys();

        for (Integer m : moneys) {
            int count = 0;
            while (money >= m) {
                money -= m;
                count++;
            }
            answer.add(count);
        }

        return answer;
    }

}
