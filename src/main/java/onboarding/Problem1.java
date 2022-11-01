package onboarding;

import java.util.List;

class Score {
    public int score = 0;

    public Score(List<Integer> player) {   // 생성자
        for (int num : player) {
            int side_score = Math.max(get_add(num), get_mul(num));
            if (score < side_score)
                score = side_score;
        }
    }

    private int get_add(int num) {
        int sum = 0;

        while (0 < num) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private int get_mul(int num) {
        int mul = 1;

        while (0 < num) {
            mul *= num % 10;
            num /= 10;
        }
        return mul;
    }
}

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Score pobi_score = new Score(pobi);
        Score crong_score = new Score(crong);

        if (handlingExceptions(pobi) || handlingExceptions(crong))
            return EXCEPTION;
        return findWinner(pobi_score, crong_score);
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

    private static int findWinner(Score pobi, Score crong) {
        if (pobi.score < crong.score)
            return CRONG_WIN;
        else if (crong.score < pobi.score)
            return POBI_WIN;
        return DRAW;
    }
}

