package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int numberOfClap = 0;
        for (int i = 0; i <= number; i++) {
            numberOfClap += count369(i);
        }
        return numberOfClap;
    }

    private static int check369(int digit) {
        List<Integer> checkList = List.of(3, 6, 9);

        if (checkList.contains(digit))
            return 1;
        return 0;
    }

    private static int count369(int number) {
        int numberOf369 = 0;
        while (number > 0) {
            int digit = number % 10;
            numberOf369 += check369(digit);
            number /= 10;
        }
        return numberOf369;
    }
}
