package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int myMoney;
    public static List<Integer> answer;

    public static List<Integer> solution(int money) {
        myMoney = money;
        answer = new ArrayList<>();
        if (!Validator.isValidate(myMoney)){
            return null;
        }
        convertToUnit();
        return answer;
    }

    private static void convertToUnit(){
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int unit : units){
            exchangeMoney(unit);
        }
    }

    private static void exchangeMoney(int unit){
        int maxUnitCount = getMaxUnitCount(unit);
        myMoney -= maxUnitCount * unit;
        answer.add(maxUnitCount);
    }

    private static int getMaxUnitCount(int unit){
        int count = 0;
        while (myMoney - (count) * unit >= unit){
            count++;
        }
        return count;
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
