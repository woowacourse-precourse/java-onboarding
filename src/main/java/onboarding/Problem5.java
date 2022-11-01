package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(money % 10);
            money /= 10;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            int now = list.get(i);
            if (i == 4) { //5만원, 1만원
                answer.add(0, now / 5);
                now %= 5;
                answer.add(1, now);
            }
            else if (i == 3) { //5천원, 1천원
                answer.add(2, now / 5);
                now %= 5;
                answer.add(3, now);
            }
            else if (i == 2) {  //5백원, 1백원
                answer.add(4, now / 5);
                now %= 5;
                answer.add(5, now);
            }
            else if (i == 1) {  //5십원, 1십원
                answer.add(6, now / 5);
                now %= 5;
                answer.add(7, now);
            }
            else if (i == 0) {  //1원
                answer.add(8, now );
            }
        }

        return answer;
    }
}
