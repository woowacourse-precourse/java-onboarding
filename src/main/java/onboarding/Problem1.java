package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!findPageException(pobi) || !findPageException(crong)) return -1;
        return answer;
    }

    public static boolean findPageException(List<Integer> user) {
        if (user.get(0) % 2 == 0) return false;
        if (user.get(1) != user.get(0) + 1) return false;
        if (user.get(0) == 1 || user.get(1) == 400) return false;
        return true;
    }
}