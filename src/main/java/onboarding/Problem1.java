package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePages(pobi) || !validatePages(crong)) {
            return -1;
        }
        return 0;
    }

    private static boolean validatePages(List<Integer> player) {
        if (player.get(1) - player.get(0) != 1) {
            return false;
        }
        for (int page : player) {
            if (page < 1 || page > 400) {
                return false;
            }
        }
        if (player.get(0) % 2 == 0 || player.get(1) % 2 != 0) {
            return false;
        }
        if (player.size() != 2) {
            return false;
        }
        return true;
    }

}