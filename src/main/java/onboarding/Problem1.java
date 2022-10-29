package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try {
            Book book1 = new Book(pobi);
            Book book2 = new Book(crong);
            answer = book1.compareTo(book2);
            return answer;
        } catch (Exception e) {
            return -1;
        }
    }
}
class Book implements Comparable<Book> {
    private static final String UNDER_OUT_OF_BOUND = "페이지 범위가 1 미만입니다.";
    private static final String UPPER_OUT_OF_BOUND = "페이지 범위가 400 초과입니다.";
    private static final Integer DEFAULT_PAGE_START = 1;
    private static final Integer DEFAULT_PAGE_END = 400;
    private static final String NOT_MATCH_FORMAT = "올바른 숫자로 입력하세요";
    private int pageBegin;
    private int pageEnd;

    Book(List<Integer> user) {
        this.pageBegin = user.get(0);
        this.pageEnd = user.get(1);
        validatePageStart(pageBegin);
        validatePageEnd(pageEnd);
        validateConsecutive(pageBegin, pageEnd);
    }

    private void validatePageStart(int pageBegin) {
        if (pageBegin < DEFAULT_PAGE_START || pageBegin % 2 == 0) {
            throw new IllegalArgumentException(UNDER_OUT_OF_BOUND);
        }
    }

    private void validatePageEnd(int pageEnd) {
        if (pageEnd > DEFAULT_PAGE_END || pageEnd % 2 == 1) {
            throw new IllegalArgumentException(UPPER_OUT_OF_BOUND);
        }
    }

    private void validateConsecutive(int pageBegin, int pageEnd) {
        if (pageEnd != pageBegin + 1) {
            throw new IllegalArgumentException(NOT_MATCH_FORMAT);
        }
    }

    private int sumEachNumber(Integer num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private int multiplyEachNumber(Integer num) {
        int total = 1;
        while (num != 0) {
            total *= num % 10;
            num /= 10;
        }
        return total;
    }

    public int calcAnswer() {
        int valPageBegin = Integer.max(sumEachNumber(this.pageBegin), multiplyEachNumber(this.pageBegin));
        int valPageEnd = Integer.max(sumEachNumber(this.pageEnd), multiplyEachNumber(this.pageEnd));
        return Integer.max(valPageBegin, valPageEnd);
    }

    @Override
    public int compareTo(Book o) {
        int compareValue = this.calcAnswer();
        int comparedValue = o.calcAnswer();
        if (compareValue > comparedValue)
            return 1;
        else if (compareValue < comparedValue)
            return 2;
        else
            return 0;
    }
}