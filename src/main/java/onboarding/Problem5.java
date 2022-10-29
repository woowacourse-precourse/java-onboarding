package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = Collections.emptyList();
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
