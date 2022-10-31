package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int moneyUnit = 50000;
        int numberOfKindOfMoney = 9;


        while (numberOfKindOfMoney > 0) {
            if(numberOfKindOfMoney>2 && numberOfKindOfMoney%2 == 1){
                answer.add(money/moneyUnit);
                money %= moneyUnit;
                moneyUnit /= 5;

            } else if (numberOfKindOfMoney>2 && numberOfKindOfMoney%2 == 0) {
                answer.add(money/moneyUnit);
                money %= moneyUnit;
                moneyUnit /= 2;
            } else if (numberOfKindOfMoney == 2){
                answer.add(money/moneyUnit);
                money %= moneyUnit;
                moneyUnit /= 10;
            } else if (numberOfKindOfMoney == 1){
                answer.add(money/moneyUnit);
            }
            numberOfKindOfMoney -= 1;

        }


        return answer;
    }
}
