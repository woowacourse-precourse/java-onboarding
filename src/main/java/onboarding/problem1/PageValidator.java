package onboarding.problem1;

import java.util.*;

public class PageValidator {

    static final int DEFAULT_PAGE_SIZE = 2;

    public GamePlayer getPlayer(List<Integer> pages) {
        validate(pages);
        return new GamePlayer(pages);
    }

    public void validate(List<Integer> pages) {
        List<Integer> validatedPages = validatePageSize(pages);
        Integer firstPage = validatedPages.get(0);
        Integer lastPage = validatedPages.get(1);

        validateContinuousPage(firstPage, lastPage);
        validateIfFirstOrLastPage(firstPage, lastPage);
    }

    private List<Integer> validatePageSize(List<Integer> pages) {
        if (DEFAULT_PAGE_SIZE != pages.size())
            throw new IllegalArgumentException("페이지 크기는 2입니다.");
        return pages;
    }

    private void validateContinuousPage(Integer firstPage, Integer lastPage) {
        if (lastPage - firstPage != 1)
            throw new IllegalArgumentException("첫 페이지와 마지막 페이지는 연속되어야 합니다.");
    }

    private void validateIfFirstOrLastPage(Integer firstPage, Integer lastPage) {
        if (checkPageRange(firstPage, lastPage))
            throw new IllegalArgumentException("해당 페이지는 펼칠 수 없습니다.");
    }

    private boolean checkPageRange(Integer firstPage, Integer lastPage) {
        return firstPage <= 1 || lastPage >= 400;
    }

}
