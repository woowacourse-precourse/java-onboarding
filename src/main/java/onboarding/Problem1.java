package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            if(!isContinuousPages(pobi.get(LEFT), pobi.get(RIGHT)) || !isContinuousPages(crong.get(LEFT), crong.get(RIGHT))) {
                throw new IllegalArgumentException();
            }

            int pobiScore = Math.max(maxBetweenSumAndMultipleAllDigits(pobi.get(LEFT), LEFT), maxBetweenSumAndMultipleAllDigits(pobi.get(RIGHT), RIGHT));
            int crongScore = Math.max(maxBetweenSumAndMultipleAllDigits(crong.get(LEFT), LEFT), maxBetweenSumAndMultipleAllDigits(crong.get(RIGHT), RIGHT));

            return (pobiScore == crongScore) ? ResultType.DRAW.resultValue : ((pobiScore > crongScore) ? ResultType.POBI_WIN.resultValue : ResultType.CRONG_WIN.resultValue);

        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    private static int maxBetweenSumAndMultipleAllDigits(int page, int direction) {

        if(!isValidPage(page)) {
            throw new IllegalArgumentException();
        }
        if (!isValidDirectionPage(direction, page)) {
            throw new IllegalArgumentException();
        }

        int temp = page;
        int sum = 0;
        int multiple = 1;

        for (int i = 100; i >= 1; i /= 10) {
            int divide = temp / i;
            if (divide == 0) {
                continue;
            }
            sum += divide;
            multiple *= divide;
            temp %= i;
        }

        return Math.max(sum, multiple);
    }

    enum ResultType {
        POBI_WIN(1),
        CRONG_WIN(2),
        DRAW(0),
        EXCEPTION(-1);

        private int resultValue;

        ResultType(int resultValue) {
            this.resultValue = resultValue;
        }

        public int getResultValue() {
            return resultValue;
        }
    }

    /**
     * 두 페이지가 연속적인지 확인하는 메서드
     */
    private static boolean isContinuousPages(int left, int right) {
        if (right - left == 1) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 페이지 번호가 1과 400 사이에 있는지 확인 메서드
     */
    private static boolean isValidPage(int page) {
        if(page > 1 && page < 400) {
            return true;
        }else {
            return false;
        }
    }
    /**
     * 왼쪽의 페이지는 홀수, 오른쪽 페이지는 짝수인지 확인
     */
    private static boolean isValidDirectionPage(int direction, int page) {
        if ((direction == LEFT && (page % 2 != 1)) || (direction == RIGHT && (page % 2 != 0))) {
            return false;
        }
        return true;
    }
}