package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {

    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;

    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);

        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (!isValidPage(pobiLeftPage, pobiRightPage)
                || !isValidPage(crongLeftPage, crongRightPage)) {
            return EXCEPTION;
        }

        List<Integer> pobiNumbers = getAllNumbers(pobiLeftPage, pobiRightPage);
        List<Integer> crongNumbers = getAllNumbers(crongLeftPage, crongRightPage);

        int pobiScore = getMaxScore(pobiNumbers);
        int crongScore = getMaxScore(crongNumbers);

        int answer = getAnswer(pobiScore, crongScore);

        return answer;
    }

    private static char[] getEachPageNumbers(int page) {
        String s = Integer.toString(page);
        return s.toCharArray();
    }

    private static int getPageSum(char[] pageNumbers) {
        int result = 0;
        for (char c : pageNumbers) {
            result += c - '0';
        }
        return result;
    }

    private static int getPageMultiply(char[] pageNumbers) {
        int result = 1;
        for (char c : pageNumbers) {
            result *= c - '0';
        }
        return result;
    }

    private static List<Integer> getAllNumbers(int leftPage, int rightPage) {
        List<Integer> numbers = new ArrayList<>();

        char[] leftEachPageNumbers = getEachPageNumbers(leftPage);
        char[] rightEachPageNumbers = getEachPageNumbers(rightPage);

        // 가능한 4가지 값을 모두 List에 추가
        numbers.add(getPageSum(leftEachPageNumbers));
        numbers.add(getPageSum(rightEachPageNumbers));
        numbers.add(getPageMultiply(leftEachPageNumbers));
        numbers.add(getPageMultiply(rightEachPageNumbers));

        return numbers;
    }

    private static int getMaxScore(List<Integer> numbers) {
        Integer maxScore = Collections.max(numbers);
        return maxScore;
    }

    private static int getAnswer(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    private static boolean isValidPage(int leftPage, int rightPage) {
        if (rightPage - leftPage != 1) {
            return false;
        }
        if (leftPage < FIRST_PAGE || rightPage > LAST_PAGE) {
            return false;
        }
        return true;
    }
}