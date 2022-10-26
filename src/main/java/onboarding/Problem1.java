package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            validateInput(pobi, crong);
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

    public static void validateInput(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2) {
            throw new IllegalArgumentException("Invalid input size");
        }

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