package onboarding;

import java.util.List;

class Problem1 {
    private static boolean checkList(List<Integer> list) {
        if (list.size() != 2)
            return false;
        if (list.get(0) % 2 == 0 || list.get(1) != (list.get(0) + 1))
            return false;
        if (list.get(0) <= 1 || list.get(1) >= 400)
            return false;
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

    }

}