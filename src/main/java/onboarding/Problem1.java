package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {

    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;
    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;
    private static final int ANSWER_EXCEPTION = -1;
    private static final int ANSWER_DRAW = 0;
    private static final int ANSWER_POBI_WIN = 1;
    private static final int ANSWER_CRONG_WIN = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (validatePlayerNotReady(pobi)) {
            return ANSWER_EXCEPTION;
        }
        if (validatePlayerNotReady(crong)) {
            return ANSWER_EXCEPTION;
        }

        int pobiPoint = findMaxPoint(pobi);
        int crongPoint = findMaxPoint(crong);

        return findWinner(pobiPoint, crongPoint);
    }

    private static boolean validatePlayerNotReady(List<Integer> player) {
        int leftPage = findPage(player, LEFT_PAGE_INDEX);
        int rightPage = findPage(player, RIGHT_PAGE_INDEX);
        boolean playerNotReady = false;

        if (validatePagesNotContinuous(leftPage, rightPage)) {
            playerNotReady = true;
        }
        if (validatePageNotExists(leftPage)) {
            playerNotReady = true;
        }
        if (validatePageNotExists(rightPage)) {
            playerNotReady = true;
        }

        return playerNotReady;
    }

    private static boolean validatePagesNotContinuous(int leftPage, int rightPage) {
        return rightPage - leftPage != 1;
    }

    private static boolean validatePageNotExists(int page) {
        return MIN_PAGE > page || page > MAX_PAGE;
    }

    private static int findMaxPoint(List<Integer> player) {
        int leftPage = findPage(player, LEFT_PAGE_INDEX);
        int rightPage = findPage(player, RIGHT_PAGE_INDEX);

        List<Integer> leftPageCiphers = parsePageToCiphers(leftPage);
        List<Integer> rightPageCiphers = parsePageToCiphers(rightPage);

        return comparePoint(leftPageMaxPoint, rightPageMaxPoint);
    }

    private static int findPage(List<Integer> player, int pageSide) {
        return player.get(pageSide);
    }

    private static List<Integer> parsePageToCiphers(int page) {
        return Stream.of(String.valueOf(page).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    private static int findWinner(int pobi, int crong) {
        int compareResult = Integer.compare(pobi, crong);

        if (compareResult == 1) {
            return ANSWER_POBI_WIN;
        }
        if (compareResult == -1) {
            return ANSWER_CRONG_WIN;
        }
        if (compareResult == 0) {
            return ANSWER_DRAW;
        }
        return ANSWER_EXCEPTION;
    }


}