package onboarding;

import java.util.List;

class Problem1 {
    // TODO: define appropriate names for results

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Spread pobisPages;
        Spread crongsPages;
        try {
            pobisPages = new Spread(pobi);
            crongsPages = new Spread(crong);
        } catch (IllegalArgumentException e) {
            return (-1);
        }

        // Get and return result

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // TODO: int result(int pobi, int crong)
}

class Spread {
    private final Page LEFT;
    private final Page RIGHT;

    Spread(List<Integer> player) {
        if (player.size() != 2) {
            throw new IllegalArgumentException();
        }
        int left = player.get(0);
        int right = player.get(1);
        if (left < 1 || 399 < left || left % 2 == 0 || right != left + 1) {
            throw new IllegalArgumentException();
        }
        LEFT = new Page(left);
        RIGHT = new Page(right);
    }

    int score() {
        int leftScore = LEFT.getScore();
        int rightScore = RIGHT.getScore();
        return Math.max(leftScore, rightScore);
    }

    private static class Page {
        private final int NUMBER;

        Page(int number) {
            this.NUMBER = number;
        }

        // TODO: getScore()
        int getScore() {
            return 0;
        }

        // TODO: addDigits()

        // TODO: multiplyDigits()

    }
}
