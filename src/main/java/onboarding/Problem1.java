package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        if (handlingExceptions(pobi) || handlingExceptions(crong))
            return EXCEPTION;

        return answer;
    }

    private static boolean handlingExceptions(List<Integer> player) {
        if (player.size() != 2)
            return true;
        if (player.get(0) % 2 != 1 || player.get(1) % 2 != 0)
            return true;
        if (player.get(1) - player.get(0) != 1)
            return true;
        if (player.get(0) < 2 || 399 < player.get(1))
            return true;
        return false;
    }
}