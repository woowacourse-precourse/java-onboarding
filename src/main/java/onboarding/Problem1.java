package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean checkException(List<Integer> list) {
        if (list.get(0) + 1 != list.get(1)) {
            return false;
        }
        if (list.get(0) % 2 != 1 || list.get(1) % 2 != 0) {
            return false;
        }
        if (list.size() != 2) {
            return false;
        }
        return true;
    }


}