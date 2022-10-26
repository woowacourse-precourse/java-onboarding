package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi == null || crong == null) {
            return -1;
        }

        if (isInvalidPageList(pobi) || isInvalidPageList(crong)) {
            return -1;
        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean isInvalidPageList(List<Integer> pageList) {
        if (pageList.size() != 2) {
            return true;
        }

        if (pageList.stream().anyMatch(page -> page <= 1 || page >= 400)) {
            return true;
        }

        if ((pageList.get(0) % 2 != 1) || (pageList.get(1) % 2 != 0)) {
            return true;
        }

        if ((pageList.get(1) - pageList.get(0)) != 1) {
            return true;
        }

        return false;
    }
}