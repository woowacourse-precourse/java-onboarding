package onboarding;

import org.mockito.internal.matchers.CompareTo;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        if (!isPossiblePage(pobi, crong)) {
            return -1;
        }

        return answer;
    }

    private static boolean isPossiblePage(List<Integer> pobi, List<Integer> crong) {
        List<Integer> allPageList = new ArrayList<>();
        allPageList.addAll(pobi);
        allPageList.addAll(crong);
        if (!validatePageBoundary(allPageList)) {
            return false;
        }
        if (!validatePageConnectivity(pobi, crong)) {
            return false;
        }
        return true;
    }

    private static boolean validatePageConnectivity(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) != pobi.get(0)+1) {
            return false;
        }
        if (crong.get(1) != crong.get(0)+1) {
            return false;
        }
        return true;
    }

    private static boolean validatePageBoundary(List<Integer> allPageList) {
        for (int page : allPageList) {
            if (page < 1 || page > 400) {
                return false;
            }
        }
        return true;
    }
}