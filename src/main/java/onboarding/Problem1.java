package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static final int firstPage = 1;
    public static final int LastPage = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pLeftPage = pobi.get(0);
        int pRightPage = pobi.get(1);

        int cLeftPage = crong.get(0);
        int cRightPage = crong.get(1);

        if(validation(pLeftPage, pRightPage)) {
            return -1;
        }

        if(validation(cLeftPage, cRightPage)) {
            return -1;
        }

        ArrayList<Integer> pLeftList = new ArrayList<>();
        ArrayList<Integer> pRightList = new ArrayList<>();

        addList(pLeftPage, pLeftList);
        addList(pRightPage, pRightList);

        int pLeftBigNumber = calculateNumber(pLeftList);
        int pRightBigNumber = calculateNumber(pRightList);

        ArrayList<Integer> cLeftList = new ArrayList<>();
        ArrayList<Integer> cRightList = new ArrayList<>();

        int cLeftBigNumber = calculateNumber(cLeftList);
        int cRightBigNumber = calculateNumber(cRightList);

        addList(cLeftPage, cLeftList);
        addList(cRightPage, cRightList);

        return answer;
    }

    private static int calculateNumber(ArrayList<Integer> list) {
        int sum = 0;
        int multiplication = 1;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            multiplication *= list.get(i);
        }
        return Math.max(sum, multiplication);
    }

    private static boolean validation(int leftPage, int rightPage) {
        return isLeftOddNumberAndRightEvenNumberPage(leftPage, rightPage) || isNextPage(leftPage, rightPage) || isFirstAndLastPage(leftPage, rightPage);
    }

    private static boolean isFirstAndLastPage(int leftPage, int rightPage) {
        return leftPage == firstPage || rightPage == LastPage;
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
