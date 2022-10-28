package onboarding;

import java.util.List;

class Problem1 {
    static final int ERROR = -1;
    static final int TIE = 0;
    static final int POBI_WIN = 1;
    static final int CRONG_WIN = 2;
    static final int PAGE_LENGTH_MIN = 1;
    static final int PAGE_LENGTH_MAX = 400;
    static final int INPUT_LENGTH = 2;
    static final int LEFT_PAGE_INDEX = 0;
    static final int RIGHT_PAGE_INDEX = 1;

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
        answer = getAnswer(pobiScore, crongScore);
        return answer;
    }

    private static int getAnswer(int pobiScore, int crongScore) {
        int answer = Integer.MAX_VALUE;

        if (pobiScore > crongScore) {
            answer = POBI_WIN;
        }
        if (pobiScore < crongScore) {
            answer = CRONG_WIN;
        }
        if (pobiScore == crongScore) {
            answer = TIE;
        }
        return answer;
    }

    private static int calculateScore(List<Integer> userInput) {
        int leftPage = getLeftPage(userInput);
        int rightPage = getRightPage(userInput);
        int sum = getBiggerSum(leftPage, rightPage);
        int mul = getBiggerMultiply(leftPage, rightPage);

        return sum > mul ? sum : mul;
    }

    private static int getLeftPage(List<Integer> userInput) {
        return userInput.get(LEFT_PAGE_INDEX);
    }

    private static int getRightPage(List<Integer> userInput) {
        return userInput.get(RIGHT_PAGE_INDEX);
    }

    private static int getBiggerSum(int leftPage, int rightPage) {
        int leftSum = getSum(leftPage);
        int rightSum = getSum(rightPage);

        return leftSum > rightSum ? leftSum : rightSum;
    }

    private static int getSum(int page) {
        int sum = 0;

        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    private static int getBiggerMultiply(int leftPage, int rightPage) {
        int leftMul = getMul(leftPage);
        int rightMul = getMul(rightPage);

        return leftMul > rightMul ? leftMul : rightMul;
    }

    private static int getMul(int page) {
        int mul = 1;

        while (page > 0) {
            mul *= page % 10;
            page /= 10;
        }
        return mul;
    }

    private static boolean isValidInput(List<Integer> userInput) {
        return (isNotNull(userInput) && isValidSize(userInput) && isConnectedPage(userInput)
            && isOddEvenSequence(userInput) && isValidRange(userInput));
    }

    private static boolean isNotNull(List<Integer> userInput) {
        return userInput != null;
    }

    private static boolean isValidSize(List<Integer> userInput) {
        return userInput.size() == INPUT_LENGTH;
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

        return (leftPage >= PAGE_LENGTH_MIN && rightPage <= PAGE_LENGTH_MAX);
    }
}
