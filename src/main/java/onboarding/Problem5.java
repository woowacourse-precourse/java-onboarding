package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static int currentMoney;

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static int getQuotient(int divMoney){
        int quotient;
        quotient = currentMoney / divMoney;
        return quotient;
    }

    public static int getRemainder(int divMoney){
        int remainder;
        remainder = currentMoney % divMoney;
        return remainder;
    }
}
