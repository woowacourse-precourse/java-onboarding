package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private enum PageDirection {
        LEFT(0),
        RIGHT(1);

        private final int index;

        PageDirection(int index) {
            this.index = index;
        }
    }

    private enum Result {
        POBI(1),
        CRONG(2),
        DRAW(0),
        EXCEPTION(-1);

        private final int number;

        Result(int number) {
            this.number = number;
        }
    }
}