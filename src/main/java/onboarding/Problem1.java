package onboarding;

import java.util.List;

class Problem1 {
    // TODO: define appropriate names for results

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        var pobisPages = new Spread(pobi);
        var crongsPages = new Spread(crong);

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
        LEFT = new Page(player.get(0));
        RIGHT = new Page(player.get(1));
    }

    // TODO: int score()

    private static class Page {
        private final int NUMBER;

        Page(int number) {
            this.NUMBER = number;
        }

        // TODO: getScore()

        // TODO: addDigits()

        // TODO: multiplyDigits()

    }
}
