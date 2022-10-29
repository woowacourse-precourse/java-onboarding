package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}

class Page {

    private static final Integer MIN_PAGE = 1;
    private static final Integer MAX_PAGE = 400;
    private static final String NOT_ALLOWED_UNDER_MIN_PAGE = "책의 최소 페이지 수는 1입니다.";
    private static final String NOT_ALLOWED_OVER_MAX_PAGE = "책의 최대 페이지 수는 400입니다.";

    public Page(int pageNumber) {
        validateMinPage();
        validateMaxPage();
        this.pageNumber = pageNumber;
    }

    private final Integer pageNumber;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public int sumPage() {
        return Stream.of(String.valueOf(pageNumber).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public int multiplePage() {
        return Stream.of(String.valueOf(pageNumber).split(""))
                .mapToInt(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);
    }

    private void validateMinPage() {
        if (pageNumber < MIN_PAGE) {
            throw new IllegalStateException(NOT_ALLOWED_UNDER_MIN_PAGE);
        }
    }

    private void validateMaxPage() {
        if (pageNumber > MAX_PAGE) {
            throw new IllegalStateException(NOT_ALLOWED_OVER_MAX_PAGE);
        }
    }
}