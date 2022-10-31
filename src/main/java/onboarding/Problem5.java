package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] MONEY_VALUES={50000,10000,5000,1000,500,100,50,10,1};
    private static final int MONEY_TYPE_SIZE=9;

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int withdrawalAmount=money;
        for(int i=0;i<MONEY_TYPE_SIZE;i++){
            answer.add(calculateNumberOfMoney(withdrawalAmount,MONEY_VALUES[i]));
            withdrawalAmount=calculateRestOfMoney(withdrawalAmount,MONEY_VALUES[i]);
        }

        return answer;
    }

    private static Integer calculateNumberOfMoney(int withdrawalAmount, int moneyValue) {
        return withdrawalAmount/moneyValue;
    }

    private static int calculateRestOfMoney(int withdrawalAmount, int moneyValue) {
        return withdrawalAmount%moneyValue;
    }
}
