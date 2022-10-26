package onboarding;

import java.util.List;

class Problem1 {
    public static final int DRAW = 0;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int EXCEPTIONS_OCCURED = -1;

    public static final int SIZE_OF_PAGES = 2;
    public static final int FIRST_PAGE_NUMBER = 1;
    public static final int LAST_PAGE_NUMBER = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!validateAllPages(pobi, crong)) {
            return EXCEPTIONS_OCCURED;
        }

        return answer;
    }

    public static boolean validateAllPages(List<Integer> pobi, List<Integer> crong) {
        return (validate(pobi) && validate(crong));
    }

    //무슨 에러인지 찾아볼 것.
    private static boolean validate(List<Integer> pages) {
        return (validateLength(pages) && validateConsecutivePages(pages) && validateNotFirstOrLastPages(pages));
    }

    private static boolean validateLength(List<Integer> pages) {
        return (pages.size() == SIZE_OF_PAGES);
    }

    private static boolean validateConsecutivePages(List<Integer> pages) {
        return (pages.get(0) % 2 == 1 && pages.get(0) + 1 == pages.get(1));
    }

    private static boolean validateNotFirstOrLastPages(List<Integer> pages){
        return (pages.get(0) != FIRST_PAGE_NUMBER && pages.get(1) != LAST_PAGE_NUMBER);
    }
}