package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = makeCharge(money);
        return answer;
    }

    //금액을 입력받으면 거스름돈을 계산하는 기능
    static List<Integer> makeCharge(int money){
        int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i<9; i++){
            result.add(money/arr[i]);
            money %= arr[i];
        }

        return result;
    }
}
