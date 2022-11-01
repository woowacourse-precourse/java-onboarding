package onboarding;

import java.util.List;

class Problem1 {
    final private static int POBI_WIN = 1;
    final private static int CRONG_WIN = 2;
    final private static int DRAW = 0;
    final private static int EXCEPTION = -1;
    static int playerCounter = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi, crong)) return EXCEPTION;
        return play(pobi, crong);
    }

    private static int play(List<Integer> pobi, List<Integer> crong) {
        Integer pobiScore = maxScore(pobi.get(0), pobi.get(1));
        Integer crongScore = maxScore(crong.get(0), crong.get(1));

        if (pobiScore > crongScore) return POBI_WIN;
        if (pobiScore.equals(crongScore)) return DRAW;

        return CRONG_WIN;
    }

    private static int maxScore(Integer left, Integer right) {
        int sumScore = Math.max(sum(left), sum(right));
        int mulScore = Math.max(mul(left), mul(right));

        return Math.max(sumScore, mulScore);
    }

    private static int sum(Integer page) {
        int result = 0;
        while (page > 0) {
            result += page % 10;
            page /= 10;
        }
        return result;
    }

    private static int mul(Integer page) {
        int result = 1;
        while (page > 0) {
            result *= page % 10;
            page /= 10;
        }
        return result;
    }

    private static boolean isException(List<Integer> pobi, List<Integer> crong) {
        try {
            playerCounter = 0;
            new Validation(pobi).validate();
            new Validation(crong).validate();
        } catch (ValidationException e) {
            System.out.println(whoIsErrorPlayer() + e);
            return true;
        }

        return false;
    }

    private static String whoIsErrorPlayer() {
        StringBuilder result = new StringBuilder();
        if (playerCounter == 0) result.append("pobi");
        else result.append("crong");

        return result.append("의 페이지에서 문제가 발견되었습니다.\n").toString();
    }

    private static class Validation {
        private List<Integer> player;

        Validation(List<Integer> player) {
            this.player = player;
        }

        public void validate() throws ValidationException {
            int left = player.get(0);
            int right = player.get(1);
            isLenEqualsTwo(player.size());
            isLeftOdd(left);
            isRightEven(right);
            isMoreThanMinimum(left);
            isLessThanMaximum(right);
            isNextPage(left, right);
            playerCounter++;
        }

        private void isLenEqualsTwo(Integer len) throws ValidationException {
            if (len != 2) throw new ValidationException("펼친 페이지는 총 2페이지여야 합니다.");
        }

        private void isLeftOdd(Integer left) throws ValidationException {
            if (left % 2 == 0) throw new ValidationException("왼쪽 페이지는 홀수여야 합니다.");
        }

        private void isRightEven(Integer right) throws ValidationException {
            if (right % 2 != 0) throw new ValidationException("오른쪽 페이지는 짝수여야 합니다.");
        }

        private void isMoreThanMinimum(Integer left) throws ValidationException {
            if (left < 1) throw new ValidationException("1페이지보다 커야 합니다.");
        }

        private void isLessThanMaximum(Integer right) throws ValidationException {
            if (right > 400) throw new ValidationException("400페이지보다 작아야 합니다.");
        }

        private void isNextPage(Integer left, Integer right) throws ValidationException {
            if (right - left != 1) throw new ValidationException("오른쪽 페이지는 항상 왼쪽 페이지의 다음 페이지여야 합니다.");
        }
    }
}

class ValidationException extends Exception {
    ValidationException(String message) {
        super(message);
    }
}