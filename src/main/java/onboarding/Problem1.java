package onboarding;

import java.util.List;

class Problem1 {
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
        return true;
    }

    private static boolean isConsecutive(List<Integer> pageList) {
        return pageList.get(0) + 1 == pageList.get(1);
    }
}