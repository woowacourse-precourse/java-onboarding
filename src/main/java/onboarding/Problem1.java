package onboarding;

import java.util.List;

class Problem1 {
    static final int ERROR = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore;
        int crongScore;

        if (!isValidInput(pobi) || !isValidInput(crong)) {
            answer = ERROR;
            return answer;
        }
        pobiScore = calculateScore(pobi);
        crongScore = calculateScore(crong);
        return answer;
    }

    private static int calculateScore(List<Integer> userInput) {
        int leftPage;
        int rightPage;
        int sum;
        int mul;

        leftPage = getLeftPage(userInput);
        rightPage = getRightPage(userInput);
        sum = getBiggerSum(leftPage, rightPage);
        mul = getBiggerMultiply(leftPage, rightPage);
        return sum > mul ? sum : mul;
    }

    private static int getLeftPage(List<Integer> userInput) {
        return userInput.get(0);
    }

    private static int getRightPage(List<Integer> userInput) {
        return userInput.get(1);
    }

    private static int getBiggerSum(int leftPage, int rightPage) {
        int leftSum = 0;
        int rightSum = 0;

        while (leftPage > 0) {
            leftSum += leftPage % 10;
            leftPage /= 10;
        }
        while (rightPage > 0) {
            rightSum += rightPage % 10;
            rightPage /= 10;
        }
        return leftSum > rightSum ? leftSum : rightSum;
    }

    private static int getBiggerMultiply(int leftPage, int rightPage) {
        int leftMul = 1;
        int rightMul = 1;

        while (leftPage > 0) {
            leftMul *= leftPage % 10;
            leftPage /= 10;
        }
        while (rightPage > 0) {
            rightMul *= rightPage % 10;
            rightPage /= 10;
        }
        return leftMul > rightMul ? leftMul : rightMul;
    }

    private static boolean isValidInput(List<Integer> userInput) {
        return (isNotNull(userInput) && isValidSize(userInput) && isConnectedPage(userInput)
            && isOddEvenSequence(userInput) && isValidRange(userInput));
    }

    private static boolean isNotNull(List<Integer> userInput) {
        return userInput != null;
    }

    private static boolean isValidSize(List<Integer> userInput) {
        return userInput.size() == 2;
    }

    private static boolean isConnectedPage(List<Integer> userInput) {
        int leftPage = getLeftPage(userInput);
        int rightPage = getRightPage(userInput);

        return rightPage - leftPage == 1;
    }

    private static boolean isOddEvenSequence(List<Integer> userInput) {
        int leftPage = getLeftPage(userInput);
        int rightPage = getRightPage(userInput);

        return isOdd(leftPage) && isEven(rightPage);
    }

    private static boolean isOdd(int num) {
        return num % 2 == 1;
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static boolean isValidRange(List<Integer> userInput) {
        int leftPage = getLeftPage(userInput);
        int rightPage = getRightPage(userInput);

        return leftPage >= 1 && rightPage <= 400;
    }
}
