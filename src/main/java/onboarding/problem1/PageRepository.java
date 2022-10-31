package onboarding.problem1;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class PageRepository {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    private final Page leftPage;
    private final Page rightPage;

    PageRepository(List<Integer> pages) {
        this.leftPage = new Page(pages.get(LEFT_PAGE));
        this.rightPage = new Page(pages.get(RIGHT_PAGE));
    }

    public int leftPageBiggestScore() {
        List<Integer> pages = Arrays.asList(leftPage.getSum(), leftPage.getMult());
        return Collections.max(pages);
    }
    public int rightPageBiggestScore() {
        List<Integer> pages = Arrays.asList(rightPage.getSum(), rightPage.getMult());
        return Collections.max(pages);
    }
    public int BiggestScore() {
        List<Integer> scores = Arrays.asList(leftPageBiggestScore(), rightPageBiggestScore());
        return Collections.max(scores);
    }
}
