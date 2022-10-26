package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!checkPage(pobi) || !checkPage(crong)) {
            return -1;
        }
        return answer;
    }

    public static boolean checkPage(List<Integer> list) {
        if (list.size() != 2) return false;
        if (Math.abs(list.get(1) - list.get(0)) != 1) return false;
        return true;
    }
}