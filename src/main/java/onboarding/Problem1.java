package onboarding;

import java.util.List;
import java.util.stream.Stream;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer;

        if (isInValidPages(pobi)|| isInValidPages(crong)) {
            return -1;
        }

        int pobiScore = getMaxScore(pobi);
        int crongScore = getMaxScore(crong);

        answer = getWinner(pobiScore, crongScore);
        return answer;
    }


    private static boolean isInValidPages(List<Integer> pages) {
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);

        if (isInValidRange(leftPage) || isInValidRange(rightPage)) {
            return true;
        }

        if (isEven(leftPage) || isOdd(rightPage)) {
            return true;
        }

        return isNotConsecutive(leftPage, rightPage);
    }

    private static boolean isInValidRange(Integer page) {
        return page < 1 || page > 400;
    }

    private static boolean isEven(Integer page) {
        return page % 2 == 0;
    }

    private static boolean isOdd(Integer page) {
        return !isEven(page);
    }

    private static boolean isNotConsecutive(Integer leftPage, Integer rightPage) {
        return rightPage - leftPage != 1;
    }

    private static int getMaxScore(List<Integer> pages) {
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);
        return Stream.of(sum(leftPage), sum(rightPage), multiply(leftPage), multiply(rightPage))
                .mapToInt(score -> score)
                .max()
                .getAsInt();
    }

    private static int sum(int page) {
        int ret = 0;

        while (page > 0) {
            ret += (page % 10);
            page /= 10;
        }

        return ret;
    }

    private static int multiply(int page) {
        int ret = 1;

        while (page > 0) {
            ret *= (page % 10);
            page /= 10;
        }

        return ret;
    }

    private static int getWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

}
