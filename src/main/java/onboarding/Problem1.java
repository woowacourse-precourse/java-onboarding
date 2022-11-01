package onboarding;

import java.util.List;

class Problem1 {
    public static final int LEFT_IDX = 0;
    public static final int RIGHT_IDX = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = getUserScore(pobi);
        int crongScore = getUserScore(crong);

        if(pobiScore == -1 || crongScore == -1) {
            return -1;
        }

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (crongScore > pobiScore) {
            answer = 2;
        } else if (crongScore == pobiScore) {
            answer = 0;
        } else {
            answer = -1;
        }

        return answer;
    }

    private static int getUserScore(List<Integer> pageList) {
        if (validateListSize(pageList) == false) return -1;

        int leftPage = pageList.get(LEFT_IDX);
        int rightPage = pageList.get(RIGHT_IDX);

        if (validateLeftPageOddAndRightPageEven(leftPage, rightPage) == false) return -1;
        if (validateAdjacentPage(leftPage, rightPage) == false) return -1;

        int leftScore = getLargerValue(leftPage);
        int rightScore = getLargerValue(rightPage);

        return Math.max(leftScore, rightScore);
    }

    private static int getLargerValue(int page) {
        if (validatePageRange(page) == false) return -1;

        String[] splitNums = String.valueOf(page).split("");

        int acc = 0;
        int mul = 1;

        for (String splitNum : splitNums) {
            acc += Integer.parseInt(splitNum);
            mul *= Integer.parseInt(splitNum);
        }

        return Math.max(acc, mul);
    }

    private static Boolean validateListSize(List<Integer> pageList) {
        if (pageList.size() != 2) {
            return false;
        }

        return true;
    }

    private static Boolean validatePageRange(int page) {
        if ((page < 1 || page > 400)) {
            return false;
        }

        return true;
    }

    private static Boolean validateAdjacentPage(int leftPage, int rightPage) {
        if (rightPage - leftPage != 1) {
            return false;
        }

        return true;
    }

    private static Boolean validateLeftPageOddAndRightPageEven(int leftPage, int rightPage) {
        if (leftPage % 2 == 0 || rightPage % 2 == 1) {
            return false;
        }

        return true;
    }
}