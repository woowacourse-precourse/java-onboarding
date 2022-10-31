package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int ConvertMoney(int money, int target){
        return money/target;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        int[] pivot = {50000, 10000, 1000, 500, 100, 50, 10, 1};
        for(int i=0;i<pivot.length;i++){
            answer.add(ConvertMoney(money, pivot[i]));
            money /= pivot[i];
        }

        return answer;
    }
}
