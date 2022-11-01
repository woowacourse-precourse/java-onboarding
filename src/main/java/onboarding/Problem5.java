package onboarding;

import onboarding.newExceptions.InvalidRestrictionException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Problem5 restriction = new Problem5();
        if(restriction.isViolatedRestrictions(money)){
            throw new InvalidRestrictionException("money 가 1 이상 10,000 이하의 자연수가 아닙니다.");
        }

        List<Integer> answer = new ArrayList<>(Collections.emptyList());

        //5만원, 1만원, 5천원, 1천원, 5백원, 1백원, 50원, 10원, 1원
        int[] moneyList = {50000,10000,5000,1000,500,100,50,10,1};

        for (int comparedCurrency : moneyList) {
            if (money < comparedCurrency) {
                answer.add(0);
            } else {
                int countedCurrency = money / comparedCurrency;
                answer.add(countedCurrency);
                money -= (countedCurrency * comparedCurrency);
            }
        }
        return answer;
    }
    boolean isViolatedRestrictions(int money){
        return !(1 <= money && money <= 10_000);
    }
}
