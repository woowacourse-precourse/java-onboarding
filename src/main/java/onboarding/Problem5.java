package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int index = 0;
        int count = 0;
        int bill[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        while (index < bill.length) {
            if (money >= bill[index]) {
                count = money / bill[index];
                money = money % bill[index];
            }
            answer.add(index, count);
            count = 0;
            ++index;
        }
        return answer;
    }

}
