package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean validateCorrectPageSize(List<Integer> pobi, List<Integer> crong) {
        return pobi.size() == 2 && crong.size() == 2;
    }

    private static boolean validateCorrectPageRange(List<Integer> pages) {
        return pages.get(0) >= 1 && pages.get(1) <= 400;
    }

    private static int getMSum(int page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }

        return sum;
    }

    private static int getMul(int page) {
        int mul = 1;
        while (page > 0) {
            mul *= page % 10;
            page /= 10;
        }

        return mul;
    }

    private static int getMAxScore(List<Integer> pages) {
        return Math.max(getMSum(pages.get(0)), getMul(pages.get(1)));
    }

    private static int playGame(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getMAxScore(pobi);
        int crongScore = getMAxScore(crong);

        return pobiScore > crongScore ? 1 : pobiScore < crongScore ? 2 : 0;
    }
}