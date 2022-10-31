package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBIWINS = 1;
    private static final int CRONGWINS = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Spread pobisPages;
        Spread crongsPages;
        try {
            pobisPages = new Spread(pobi);
            crongsPages = new Spread(crong);
        } catch (IllegalArgumentException e) {
            return (EXCEPTION);
        }
        return result(pobisPages.score(), crongsPages.score());
    }

    private static int result(int pobi, int crong) {
        if (pobi == crong) {
            return (DRAW);
        }
        return (pobi > crong) ? POBIWINS : CRONGWINS;
    }
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

        int getScore() {
            return Math.max(addDigits(), multiplyDigits());
        }

        private int addDigits() {
            int number = NUMBER;
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum;
        }

        private int multiplyDigits() {
            int number = NUMBER;
            int product = 1;
            while (number > 1) {
                product *= number % 10;
                number /= 10;
            }
            return product;
        }
    }
}
