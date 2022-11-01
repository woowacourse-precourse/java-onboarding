package onboarding;

import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Validate.problem1Input(pobi, crong);
            int pobiMax = getMaxValueFromList(pobi);
            int crongMax = getMaxValueFromList(crong);
            if (pobiMax > crongMax) {
                return 1;
            } else if (pobiMax < crongMax) {
                return 2;
            }
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getMaxValueFromList(List<Integer> intList) {
        int leftPageNum = intList.get(0);
        int rightPageNum = intList.get(1);
        return Math.max(getMaxValueFromNumber(leftPageNum), getMaxValueFromNumber(rightPageNum));
    }

    public static int getMaxValueFromNumber(int number) {
        int sum = getSumOfDigits(number);
        int product = getProductOfDigits(number);
        return Math.max(sum, product);
    }

    public static int getSumOfDigits(int number) {
        int sum = 0;
        do {
            int leastSignificantDigit = number % 10;
            sum += leastSignificantDigit;
            number /= 10;
        } while (number > 0);
        return sum;
    }

    public static int getProductOfDigits(int number) {
        int product = 1;
        do {
            int leastSignificantDigit = number % 10;
            product *= leastSignificantDigit;
            number /= 10;
        } while (number > 0);
        return product;
    }
}

class Validate {
    public static void problem1Input(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        boolean validatePobi = pobiLeft <= 399 && pobiLeft % 2 == 1 && pobiRight == pobiLeft + 1;
        boolean validateCrong = crongLeft <= 399 && crongLeft % 2 == 1 && crongRight == crongLeft + 1;

        if (!validatePobi || !validateCrong) {
            throw new IllegalArgumentException("Invalid input value");
        }
    }
}
