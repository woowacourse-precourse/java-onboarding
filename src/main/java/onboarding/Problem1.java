package onboarding;

import java.lang.Math;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {

    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DROW = 0;
    private static final int ERROR = -1;

    private static final int LEFT_PAGE = 1;
    private static final int RIGHT_PAGE = 1;

    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;


    private static boolean isNotValidPages(List<Integer> pages) {
        return pages.get(LEFT_PAGE) + 1 != pages.get(RIGHT_PAGE);
    }

    private static boolean isPagesOutOfRange(List<Integer> pages) {
        return pages.contains(MIN_PAGE) | pages.contains(MAX_PAGE);
    }

    private static int reduce(int num) {
        int addition = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt)
            .reduce(0, Integer::sum);
        int multiply = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt)
            .reduce(1, (a, b) -> a * b);
        return Math.max(addition, multiply);
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isNotValidPages(pobi) | isNotValidPages(crong)) {
            return ERROR;
        }
        if (isPagesOutOfRange(pobi) | isPagesOutOfRange(crong)) {
            return ERROR;
        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }
}