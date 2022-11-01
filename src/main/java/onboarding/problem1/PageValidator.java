package onboarding.problem1;

import java.util.List;

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

}
