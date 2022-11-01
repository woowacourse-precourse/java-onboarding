package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static void convertCoin(List<Integer> answer, int money) {
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int r = money;
        int idx = 0;
        while (r != 0) {
            answer.set(idx, r / unit[idx]);
            r %= unit[idx];
            idx++;
        }
    }

    public static boolean validation(int money){
        if (money < 1 || money > 1000000){
            return false;
        }
        else{
            return true;
        }
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        if (!validation(money)){
            return null;
        }
        for (int i = 0; i < 9; i++) {
            answer.add(0);
        }
        convertCoin(answer, money);
        return answer;
    }
}
