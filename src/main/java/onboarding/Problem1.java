package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkPage(pobi) || checkPage(crong)) {
            return -1;
        }

    }

    public static boolean checkPage(List<Integer> page) {
        if (page.get(0) - page.get(1) == -1) {
            return false;
        }
        return true;
    }
}