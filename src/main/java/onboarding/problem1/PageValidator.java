package onboarding.problem1;

import java.util.List;

public class PageValidator {

    static final int DEFAULT_PAGE_SIZE = 2;

    public GamePlayer getPlayer(List<Integer> pages) {
        validate(pages);
        return new GamePlayer(pages);
    }

}
