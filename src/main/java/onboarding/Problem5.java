package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem5 {

    public int divideNumberAByNumberB(int numberA, int numberB) throws ArithmeticException{
        return numberA / numberB;
    }

    public int moduloNumberAByNumberB(int numberA, int numberB) throws ArithmeticException{
        return numberA % numberB;
    }

    public List<Integer> sortListDescendingOrder(List<Integer> list) {
        list.sort(Comparator.reverseOrder());
        return list;
    }

    public List<Integer> countEachDenominations(List<Integer> denominationList, int money) throws ArithmeticException{
        List<Integer> numberOfEachDenominations = new ArrayList<>();

        for (Integer denomination : denominationList) {
            numberOfEachDenominations.add(divideNumberAByNumberB(money, denomination));
            money = moduloNumberAByNumberB(money, denomination);
        }

        return numberOfEachDenominations;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
