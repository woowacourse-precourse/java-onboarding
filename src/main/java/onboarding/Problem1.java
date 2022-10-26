package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax = getMaxValueFromList(pobi);
        int crongMax = getMaxValueFromList(crong);
        if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        }
        return 0;
    }

    public static int getMaxValueFromList(List<Integer> intList) {
        int first = intList.get(0);
        int second = intList.get(1);
        return Math.max(getMaxValueFromNumber(first), getMaxValueFromNumber(second));
    }

    public static int getMaxValueFromNumber(int number) {
        int sum = 0, product = 1;
        do {
            int lsn = number % 10;
            sum += lsn;
            product *= lsn;
            number = number / 10;
        } while (number != 0);
        return Math.max(sum, product);
    }

}