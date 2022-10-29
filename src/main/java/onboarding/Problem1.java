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
    public Page(int pageNumber) {
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
}