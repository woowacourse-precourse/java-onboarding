package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

    }

    private enum result {
        POBI_WIN(1),
        CRONG_WIN(2),
        DRAW(0),
        EXCEPTION(-1);

        private final int code;

        result(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}