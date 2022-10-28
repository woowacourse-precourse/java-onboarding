package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 지폐 단위를 딴 곳으로 바꿔 볼까 있을만한 예외 생각하기
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> bill = new ArrayList<>(Arrays.asList(50_000, 10_000, 5000, 1000, 500, 100, 50, 10, 1));

        for(int i = 0; i < bill.size(); i++){
            int a = 0;
            a = money / bill.get(i);
            money %= bill.get(i);
            answer.add(a);
        }
        return answer;
    }
}
