package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = maxScore(pobi.get(0), pobi.get(1));
        int crongScore = maxScore(crong.get(0), crong.get(1));

        if (pobiScore == -1 || crongScore == -1) {
            answer = -1;
        } else if (pobiScore == crongScore) {
            answer = 0;
        } else if (pobiScore > crongScore) {
            answer = 1;
        } else {
            answer = 2;
        }

        return answer;
    }

    static int maxScore(int leftPage, int rightPage) {
        if (!validatePage(leftPage, rightPage)) {
            return -1;
        }
        return Math.max(getScore(leftPage), getScore(rightPage));
    }

    static int getScore(int page) {
        int plusScore = 0;
        int multipleScore = 1;

        while (page > 0) {
            plusScore += page % 10;
            multipleScore *= page % 10;
            page /= 10;
        }

        return Math.max(plusScore, multipleScore);
    }

    static boolean validatePage(int leftPage, int rightPage) {
        return leftPage % 2 == 1 && rightPage % 2 == 0 && leftPage + 1 == rightPage;
    }
}