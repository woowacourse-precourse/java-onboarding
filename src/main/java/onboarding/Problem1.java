package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static final int ERROR=-1;
    private static final int POBI_WIN=1;
    private static final int CRONG_WIN=2;
    private static final int DRAW=0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isInputValid(pobi) || !isInputValid(crong)) {
            return ERROR;
        }
        return calculateGameResult(pobi,crong);

    }

    private static Boolean isInputValid(List<Integer> person) {
        int leftPage = person.get(0);
        int rightPage = person.get(1);

        if (!isPageNotNull(leftPage, rightPage)) {
            return false;
        }
        if (isPageRangeInBook(leftPage,rightPage) && isPageInRow(leftPage,rightPage) && isOddEven(leftPage,rightPage)) {
            return true;
        }
        return false;
    }

    private static int calculateGameResult(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getMyScore(pobi);
        int crongScore = getMyScore(crong);
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    private static int getMyScore(List<Integer> person) {
        int leftPage = person.get(0);
        int rightPage = person.get(1);
        int leftHighScore = calculatePageHighScore(leftPage);
        int rightHighScore = calculatePageHighScore(rightPage);
        return Math.max(leftHighScore, rightHighScore);
    }

    private static int calculatePageHighScore(int page) {
        List<Integer> pages = separatePageByPlace(page);
        int addScore = addPageNumber(pages);
        int multiplyScore = multiplyPageNumber(pages);
        return Math.max(addScore, multiplyScore);
    }

    private static int addPageNumber(List<Integer> pages) {
        int result = pages.stream()
                .reduce(0, (a, b) -> a + b);
        return result;
    }

    private static int multiplyPageNumber(List<Integer> pages){
        int result = pages.stream()
                .reduce(1, (a, b) -> a * b);
        return result;
    }

    private static List<Integer> separatePageByPlace(int page) {
        String pageString = String.valueOf(page);
        List<Integer> pages = new ArrayList<>();
        for (int i = 0; i < pageString.length(); i++) {
            int pagePlace = pageString.charAt(i) - '0';
            pages.add(pagePlace);
        }
        return pages;
    }

    private static Boolean isPageRangeInBook(int leftPage, int rightPage) {
        if (leftPage < 1 || leftPage > 400) {
            return false;
        }
        if (rightPage < 1 || rightPage > 400) {
            return false;
        }
        return true;
    }

    private static Boolean isPageInRow(int leftPage, int rightPage) {
        if (leftPage + 1 == rightPage){
            return true;
        }
        return false;
    }

    private static Boolean isOddEven(int leftPage, int rightPage) {
        if (leftPage % 2 == 0 || rightPage % 2 == 1){
            return false;
        }
        return true;
    }

    private static Boolean isPageNotNull(Integer leftPage, Integer rightPage) {
        if (leftPage == null || rightPage == null) {
            return false;
        }
        return true;
    }
}
