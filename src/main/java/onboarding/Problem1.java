package onboarding;

import java.util.List;

class Problem1 {

    static private final int EXCEPTION_ANSWER = -1;
    static private final int POBI_WIN = 1;
    static private final int CRONG_WIN = 2;
    static private final int DRAW = 0;
    static private final int FIRST_PAGE = 1;
    static private final int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (isException(pobiLeft, pobiRight) || isException(crongLeft, crongRight)) {
            return EXCEPTION_ANSWER;
        }

        int pobiScore = getScore(pobiLeft, pobiRight);
        int crongScore = getScore(crongLeft, crongRight);
        int answer = getAnswer(pobiScore, crongScore);
        return answer;
    }

    public static boolean isException(int leftPage, int rightPage) {
        if (leftPage < FIRST_PAGE || rightPage > LAST_PAGE) {
            return true;
        }
        if (leftPage >= rightPage) {
            return true;
        }
        if ((rightPage - leftPage) != 1) {
            return true;
        }
        return false;
    }

    public static int getScore(int leftPage, int rightPage) {
        int leftScore = getBiggerNum(leftPage);
        int rightScore = getBiggerNum(rightPage);

        return Math.max(leftScore, rightScore);
    }

    public static int getBiggerNum(int num) {
        int sum = 0, mul = 1;

        String number = String.valueOf(num);
        char[] words = number.toCharArray();
        for (char word : words) {
            sum += charToInt(word);
            mul *= charToInt(word);
        }

        return Math.max(sum, mul);
    }

    public static int charToInt(char word) {
        return word - '0';
    }

    public static int getAnswer(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (crongScore > pobiScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }
}