package onboarding.problem1;

import java.util.Arrays;
import java.util.List;

public class Calculate {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    public static int getMaxValue(List<Integer> user) {
        int leftPage = user.get(LEFT_PAGE);
        int rightPage = user.get(RIGHT_PAGE);
        int[] allPossibleValues = {getSum(leftPage),
                getSum(rightPage),
                getMult(leftPage),
                getMult(rightPage)};
        int biggest = Arrays.stream(allPossibleValues)
                .max()
                .getAsInt();
        return biggest;
    }

    public static int getSum(int number) {
        int result = 0;
        while (number != 0) {
            result += (number % 10);
            number /= 10;
        }
        return result;
    }

    public static int getMult(int number) {
        int result = 1;
        while (number != 0) {
            result *= (number % 10);
            number /= 10;
        }
        return result;
    }
}
