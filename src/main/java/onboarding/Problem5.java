package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

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
}
