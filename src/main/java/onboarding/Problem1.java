package onboarding;

import java.util.List;

class Problem1 {

    private final static int POBI_WIN = 1;
    private final static int CRONG_WIN = 2;
    private final static int DRAW = 0;
    private final static int EXCEPTION = -1;
    private final static int START_PAGE_NUMBER = 1;
    private final static int END_PAGE_NUMBER = 400;
    private final static int PAGE_GAP = 1;
    private final static int PAGE_LIST_SIZE = 2;
    
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        
        if (isInvalidPage(pobi) || isInvalidPage(crong)) {
            return EXCEPTION;
        }
        
        return answer;
    }

    private static boolean isInvalidPage(List<Integer> page) {
        return isNotValidPageSize(page) ||
                hasFirstOrLastPage(page) ||
                isNotSequencePages(page) ||
                isEven(page.get(0)) ||
                isOdd(page.get(1));
    }

    private static boolean isNotValidPageSize(List<Integer> pages) {
        return pages.size() != PAGE_LIST_SIZE;
    }

    private static boolean hasFirstOrLastPage(List<Integer> pages) {
        return pages.stream().anyMatch(page -> page == START_PAGE_NUMBER | page == END_PAGE_NUMBER);
    }

    private static boolean isNotSequencePages(List<Integer> pages) {
        return pages.get(0) + PAGE_GAP != pages.get(1);
    }

    private static boolean isOdd(int page) {
        return page % 2 == 1;
    }

    private static boolean isEven(int page) {
        return page % 2 == 0;
    }
}