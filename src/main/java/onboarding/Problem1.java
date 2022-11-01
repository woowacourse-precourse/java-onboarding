package onboarding;

import java.util.ArrayList;
import java.util.List;


class Problem1 {
    /**
     * pobi와 crong을 Verification 클래스에서 조건을 검사한다.
     * try/catch문으로 감싸 IllegalArgumentException을 받으면 -1을 리턴
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        try {
            Vericication verifyPobi = new Vericication(pobi);
            Vericication verifyCrong = new Vericication(crong);

            int maxPobiValue = verifyPobi.getMaxNum();
            int maxCrongValue = verifyCrong.getMaxNum();

            if (maxPobiValue > maxCrongValue)
                return 1;

            else if (maxPobiValue < maxCrongValue)
                return 2;

        } catch (IllegalArgumentException e) {
            return -1;
        }
        return 0;
    }
}

class Vericication {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    List<Integer> verifiedBook;

    public Vericication(List<Integer> book) throws IllegalArgumentException {
        verifyPageLength(book.size());
        verifyLeftPage(book.get(LEFT_PAGE));
        verifyRightPage(book.get(RIGHT_PAGE));
        verifyOrderedPage(book);
        this.verifiedBook = book;
    }

    private void verifyPageLength(int page) {
        if (page != 2) throw new IllegalArgumentException();
    }

    private void verifyLeftPage(Integer leftPage) {
        if (leftPage % 2 == 0) throw new IllegalArgumentException();
    }

    private void verifyRightPage(Integer rightPage) {
        if (rightPage % 2 == 1) throw new IllegalArgumentException();
    }

    private void verifyOrderedPage(List<Integer> book) {
        if (book.get(LEFT_PAGE) + 1 != book.get(RIGHT_PAGE)) throw new IllegalArgumentException();
    }

    private List<Integer> getDigitNum(Integer page) {

        List<Integer> returnDigit = new ArrayList<>();

        while (page != 0) {
            returnDigit.add(page % 10);
            page /= 10;
        }
        return returnDigit;
    }

    int getMaxNum() {
        int totalOfSum = 0;
        int totalOfMul = 1;

        for (Integer idx : verifiedBook) {
            List<Integer> digitArray = getDigitNum(idx);

            for (Integer digit : digitArray) {
                totalOfSum += digit;
                totalOfMul *= digit;
            }
        }
        return Math.max(totalOfSum, totalOfMul);
    }
}