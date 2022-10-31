package onboarding;

import java.util.List;

class Problem1 {
    static int FIRST_PAGE = 1;
    static int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!validatePageList(pobi) || !validatePageList(crong)) {
            return -1;
        }
        return answer;
    }

    private static boolean validatePageList(List<Integer> pageList) {
        if (!isConsecutive(pageList)) {
            return false;
        }
        if (!isLeftPageOdd(pageList)) {
            return false;
        }
        if (!isInRange(pageList)) {
            return false;
        }
        return true;
    }

    private static boolean isConsecutive(List<Integer> pageList) {
        return pageList.get(0) + 1 == pageList.get(1);
    }

    private static boolean isLeftPageOdd(List<Integer> pageList) {
        return pageList.get(0) % 2 == 1;
    }

    private static boolean isInRange(List<Integer> pageList) {
        if (pageList.get(0) < FIRST_PAGE) {
            return false;
        }
        if (pageList.get(1) > LAST_PAGE) {
            return false;
        }
        return true;
    }
}