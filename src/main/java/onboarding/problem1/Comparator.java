package onboarding.problem1;

import java.util.List;

public class Comparator {
    private static int compareSumAndMultiplication(int number) {
        return Math.max(Operator.sum(number), Operator.multiply(number));
    }

    private static int comparePages(int leftPage, int rightPage) {
        return Math.max(compareSumAndMultiplication(leftPage), compareSumAndMultiplication(rightPage));
    }

    public static int compareUsers(List<Integer> pobi, List<Integer> crong) {
        int result = 0;
        int pobiNumber = comparePages(pobi.get(0), pobi.get(1));
        int crongNumber = comparePages(crong.get(0), crong.get(1));
        if (pobiNumber > crongNumber) {
            result = 1;
        } else if (pobiNumber < crongNumber) {
            result = 2;
        }
        return result;
    }
}
