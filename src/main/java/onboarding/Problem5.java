package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem5 {

    public int divideNumberAByNumberB(int numberA, int numberB) throws ArithmeticException {
        return numberA / numberB;
    }

    public int moduloNumberAByNumberB(int numberA, int numberB) throws ArithmeticException {
        return numberA % numberB;
    }

    public List<Integer> sortListDescendingOrder(List<Integer> list) {
        list.sort(Comparator.reverseOrder());
        return list;
    }

    public List<Integer> countEachDenominations(List<Integer> denominationList, int money) throws ArithmeticException {
        List<Integer> numberOfEachDenominations = new ArrayList<>();

        for (Integer denomination : denominationList) {
            numberOfEachDenominations.add(divideNumberAByNumberB(money, denomination));
            money = moduloNumberAByNumberB(money, denomination);
        }

        return numberOfEachDenominations;
    }

    public List<Integer> getDenominationList() {
        return new ArrayList<>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
    }

    public static List<Integer> solution(int money) {
    return new ArrayList<>();
}
