package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!(isValidInput(pobi)&&isValidInput(crong))) {
            return -1;
        }

        return 0;
    }

    private static boolean isValidInput(List<Integer> pages) {
        return isValidRange(pages) && isContinuousNumber(pages) && isCorrectPage(pages);
    }

    private static boolean isValidRange(List<Integer> pages) {
        for (int page : pages) {
            //첫 페이지, 마지막 페이지는 펼치면 안되기 때문에 3~398의 범위를 가져야 합니다.
            if (page < 3 || 398 < page) {
                return false;
            }
        }
        return true;
    }

    private static boolean isContinuousNumber(List<Integer> pages) {
        int diff = Math.abs(pages.get(0) - pages.get(1));

        return diff == 1;
    }

    private static boolean isCorrectPage(List<Integer> pages) {
        return (pages.get(0) % 2 == 1) && (pages.get(1) % 2 == 0);
    }
}