package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static Boolean isValid(List<Integer> Pages) {
        if (Pages.size() != 2)
            return false;
        if (Pages.get(0) != Pages.get(1) - 1)
            return false;
        if (Pages.get(0) % 2 == 0)
            return false;
        if (Pages.get(1) % 2 == 1)
            return false;
        if (Pages.get(0) == 1 || Pages.get(1) == 400)
            return false;
        return true;
    }
}