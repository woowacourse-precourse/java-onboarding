package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
//        List<Integer> answer = Collections.emptyList();
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[] arr={50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int remainMoney=money;
        for (int j : arr) {
            answer.add(quotientAndRemainder(remainMoney, j)[0]);
            remainMoney = quotientAndRemainder(remainMoney, j)[1];
        }
        return answer;
    }

    static int[] quotientAndRemainder(int number, int with){
        int[] array= new int[2];
        int quotient = number / with;
        int remainder= number % with;
        array[0]= quotient;
        array[1]= remainder;
        return array;
    }

}
