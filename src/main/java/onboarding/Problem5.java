package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static int currentMoney;

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> myWallet = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        int myMoney;
        int currentQuotient;
        for(int index=0; index < myWallet.size(); index++){
            myMoney = myWallet.get(index);
            currentQuotient = getQuotient(myMoney);
            getRemainder(myMoney);
            
            answer.add(currentQuotient);
        }

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
