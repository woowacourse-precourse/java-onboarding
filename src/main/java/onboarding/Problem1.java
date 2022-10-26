package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}

class Book {
    private final int pageStart;
    private final int pageEnd;

    private static final int defaultPageStart = 0;
    private static final int defaultPageEnd = 400;

    private static void validatePageStart(int pageStart) {
        if (pageStart % 2 == 0) {
            throw new IllegalArgumentException("페이지 번호 게임을 위해서는 시작 페이지가 홀수여야 합니다!");
        }
    }

    private static void validatePageEnd(int pageEnd) {
        if (pageEnd % 2 != 0) {
            throw new IllegalArgumentException("페이지 번호 게임을 위해서는 종료 페이지가 짝수여야 합니다!");
        }
    }

    Book(int pageStart, int pageEnd) {
        validatePageStart(pageStart);
        validatePageEnd(pageEnd);
        this.pageStart = pageStart;
        this.pageEnd = pageEnd;
    }

    Book() {
        this(defaultPageStart, defaultPageEnd);
    }

    Book(int pageEnd) {
        this(defaultPageStart, pageEnd);
    }

    public int getPageStart() {
        return pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }
}
