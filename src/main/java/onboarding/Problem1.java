package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() > 2 || crong.size() > 2) {
            return -1;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore == -1 || crongScore == -1) {
            return -1;
        }

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore == crongScore) {
            return 0;
        }

        return 2;
    }

    private static int getScore(List<Integer> numbers) {
        int leftPage = numbers.get(0);
        int rightPage = numbers.get(1);

        if (rightPage - leftPage != 1) {
            return -1;
        }

        int result = numbers.stream()
            .map(Problem1::maxOfSumAndMultiply)
            .mapToInt(x -> x)
            .max()
            .getAsInt();

        return result;
    }

    private static int maxOfSumAndMultiply(int number) {
        int eachSum = eachNumberSum(number);
        int eachMul = eachNumberMultiply(number);

        if (eachSum >= eachMul) {
            return eachSum;
        }

        return eachMul;
    }

    private static int eachNumberSum(int number) {
        int result = 0;

        while (number >= 10) {
            result += number % 10;
            number /= 10;
        }
        result += number;

        return result;
    }

    private static int eachNumberMultiply(int number) {
        int result = 1;

        while (number >= 10) {
            result *= number % 10;
            number /= 10;
        }
        result *= number;

        return result;
    }

}