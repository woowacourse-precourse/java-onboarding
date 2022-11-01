package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    private static int getMaxScore(int page) {
        int sum = 0;
        int multiplication = 1;
        while (page > 0) {
            sum += page % 10;
            multiplication *= page % 10;
            page /= 10;
        }
        return Math.max(sum, multiplication);
    }

    private static int determineWinner(int pobiMaxScore, int crongMaxScore) {
        if (pobiMaxScore > crongMaxScore) {
            return 1;
        }
        if (pobiMaxScore < crongMaxScore) {
            return 2;
        }
        return 0;
    }

    private static boolean exceptionHandler(int leftPage, int rightPage) {
        if (Math.abs(leftPage - rightPage) != 1) {
            return false;
        }
        if (leftPage % 2 != 1) {
            return false;
        }
        if (rightPage % 2 != 0) {
            return false;
        }
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMaxScore = Integer.MIN_VALUE;
        int crongMaxScore = Integer.MIN_VALUE;

        if (!exceptionHandler(pobi.get(LEFT_PAGE), pobi.get(RIGHT_PAGE)) || !exceptionHandler(crong.get(LEFT_PAGE), crong.get(RIGHT_PAGE))) {
            return -1;
        }

        pobiMaxScore = Math.max(getMaxScore(pobi.get(LEFT_PAGE)), getMaxScore(pobi.get(RIGHT_PAGE)));
        crongMaxScore = Math.max(getMaxScore(crong.get(LEFT_PAGE)), getMaxScore(crong.get(RIGHT_PAGE)));

        answer = determineWinner(pobiMaxScore, crongMaxScore);

        return answer;
    }
}