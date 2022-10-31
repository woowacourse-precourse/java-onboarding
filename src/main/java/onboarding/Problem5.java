package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int fiveMillion = money / 50000;
        money -= 50000 * fiveMillion;
        int million = money / 10000;
        money -= 10000 * million;
        return answer;
    }

    private static boolean checkingExchangeTermination(int balance) {
        if (balance == 0) {
            return false;
        }
        return true;
    }


}
