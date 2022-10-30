package onboarding;

import java.util.List;

class Problem1 {
    static int POBI_WIN = 1;
    static int CRONG_WIN = -1;
    static int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi) || isException(crong)) return -1;
        int pobiScore = getScore(pobi.get(1));
        int crongScore = getScore(crong.get(1));
        return getResult(pobiScore, crongScore);
    }

    static int getScore(int i) {
        int sumDigit = sumDigits(i);
        int multipleDigit = multipleDigits(i);
        return (sumDigit > multipleDigit)?sumDigit : multipleDigit;
    }
    static int sumDigits(int i) {
        int result = 0;
        while (i > 0) {
            result += i % 10;
            i /= 10;
        }
        return result;
    }

    static int multipleDigits(int i) {
        int result = 1;
        while (i > 0) {
            result *= i % 10;
            i /= 10;
        }
        return result;
    }

    static int getResult(int pobiScore, int crongScore) {
        if (pobiScore == crongScore) return DRAW;
        return (pobiScore > crongScore) ? POBI_WIN : CRONG_WIN;
    }

    static boolean isException(List<Integer> pages) {
        return (pages.get(0) + 1 != pages.get(1))? true : false;
    }
}