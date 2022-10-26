package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int myMoney;
    public static List<Integer> answer;

    public static List<Integer> solution(int money) {
        answer = new ArrayList<>();
        myMoney = money;

        Validator.isValidate(myMoney);
        convertToUnit();
        return answer;
    }
    private static void convertToUnit(){
        subMoney(50000);
        subMoney(10000);
        subMoney(5000);
        subMoney(1000);
        subMoney(500);
        subMoney(100);
        subMoney(50);
        subMoney(10);
        subMoney(1);
    }

    private static void subMoney(int unit){
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
