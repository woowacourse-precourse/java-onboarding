package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    static class Validator{
        public static boolean isValidate(int money){
            try {
                isCorrectRange(money);
                return true;
            } catch (Exception error){
                return false;
            }
        }

        private static void isCorrectRange(int money){
            if (money < 1 || money > 1000000){
                throw new IllegalArgumentException("is not correct range");
            }
        }
    }
}
