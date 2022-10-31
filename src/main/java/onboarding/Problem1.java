package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static final int ERROR = -1;
    public static final int FIRST_PAGE = 1;
    public static final int LAST_PAGE = 400;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pLeftPage = pobi.get(0);
        int pRightPage = pobi.get(1);

        int cLeftPage = crong.get(0);
        int cRightPage = crong.get(1);

        if(validation(pLeftPage, pRightPage)) {
            return ERROR;
        }

        if(validation(cLeftPage, cRightPage)) {
            return ERROR;
        }

        ArrayList<Integer> pLeftList = new ArrayList<>();
        ArrayList<Integer> pRightList = new ArrayList<>();

        addList(pLeftPage, pLeftList);
        addList(pRightPage, pRightList);

        int pLeftBigNumber = calculateNumber(pLeftList);
        int pRightBigNumber = calculateNumber(pRightList);

        int pobiNumber = checkBigNumber(pLeftBigNumber, pRightBigNumber);

        ArrayList<Integer> cLeftList = new ArrayList<>();
        ArrayList<Integer> cRightList = new ArrayList<>();

        addList(cLeftPage, cLeftList);
        addList(cRightPage, cRightList);

        int cLeftBigNumber = calculateNumber(cLeftList);
        int cRightBigNumber = calculateNumber(cRightList);

        int crongNumber = checkBigNumber(cLeftBigNumber, cRightBigNumber);

        return getAnswer(answer, pobiNumber, crongNumber);
    }

    private static int getAnswer(int answer, int pobiNumber, int crongNumber) {
        if (pobiNumber == crongNumber) {
            answer = DRAW;
        }
        if (pobiNumber > crongNumber) {
            answer = POBI_WIN;
        }
        if (pobiNumber < crongNumber) {
            answer = CRONG_WIN;
        }
        return answer;
    }

    private static int checkBigNumber(int leftBigNumber, int rightBigNumber) {
        return Math.max(leftBigNumber, rightBigNumber);
    }

    private static int calculateNumber(ArrayList<Integer> list) {
        int sum = 0;
        int multiplication = 1;
        for (Integer slicedPageNumber : list) {
            sum += slicedPageNumber;
            multiplication *= slicedPageNumber;
        }
        return Math.max(sum, multiplication);
    }

    private static boolean validation(int leftPage, int rightPage) {
        return isLeftOddNumberAndRightEvenNumberPage(leftPage, rightPage) || isNextPage(leftPage, rightPage) || isFirstAndLastPage(leftPage, rightPage);
    }

    private static boolean isFirstAndLastPage(int leftPage, int rightPage) {
        return leftPage == FIRST_PAGE || rightPage == LAST_PAGE;
    }

    private static boolean isNextPage(int leftPage, int rightPage) {
        return rightPage - leftPage != 1;
    }

    private static boolean isLeftOddNumberAndRightEvenNumberPage(int leftPage, int rightPage) {
        return leftPage % 2 == 0 || rightPage % 2 != 0;
    }

    private static void addList(int page, ArrayList<Integer> list) {
        while (true) {
            int num = page % 10;
            if (num != 0) {
                list.add(num);
            }
            if (page / 10 == 0) {
                break;
            }
            page /= 10;
        }
    }
}
