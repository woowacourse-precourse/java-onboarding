package onboarding;

import java.util.*;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        Problem3 problem = new Problem3();
        int[] consecutiveNumbers = IntStream.range(1, number + 1).toArray();
        Set<Integer> appointedNumber = new HashSet<>(Arrays.asList(3, 6, 9));
        return Arrays.stream(consecutiveNumbers).reduce(0, (acc, cur) -> {
            List<Integer> eachDigits = problem.getDigits(cur);
            boolean hasAppointedNumber = eachDigits.stream().anyMatch(appointedNumber::contains);

           if (hasAppointedNumber) {
               int countClap =   eachDigits.stream().reduce(0, (count, digit) -> {
                   if (appointedNumber.contains(digit)) {
                       return count + 1;
                   } else {
                       return count;
                   }
               });
               return acc + countClap;
           }
           return acc;
        });
    }

    public List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        while (num > 0) {
            digits.add(num % 10);
            num = num / 10;
        }
        return digits;
    }
}
