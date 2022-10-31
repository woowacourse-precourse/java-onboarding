package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 0; i <= number; i++) {
            List<Integer> numberByDigit = divideNumberByDigit(i);
            answer += countNumberOf369(numberByDigit);
        }
        return answer;
    }

    private static List<Integer> divideNumberByDigit (int number) {
        List<Integer> result = new ArrayList();
        for (int i = number; i > 0; i /= 10) {
            result.add(i % 10);
        }
        return result;
    }

    private static int countNumberOf369 (List<Integer> numbers) {
        int numberOf369 = 0;
        for(int number: numbers) {
            if (number == 3 || number == 6 || number == 9) {
                numberOf369 += 1;
            }
        }
        return numberOf369;
    }
}
