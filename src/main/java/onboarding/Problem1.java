package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean validationCheck(List<Integer> user_1, List<Integer> user_2) {
        if (user_1.contains(1) || user_1.contains(400) ||
                user_2.contains(1) || user_2.contains(400)) {
            return false;
        } else if (user_1.get(0) < 1 || user_1.get(1) > 400 ||
                user_2.get(0) < 1 || user_2.get(1) > 400) {
            return false;
        } else if (user_1.get(1) != user_1.get(0) + 1 ||
                user_2.get(1) != user_2.get(0) + 1) {
            return false;
        } else if (user_1.get(0) % 2 != 1 ||
                user_2.get(0) % 2 != 1) {
            return false;
        } else if (user_1.size() != 2 || user_2.size() != 2) {
            return false;
        }
        return true;
    }
}