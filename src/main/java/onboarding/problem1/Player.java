package onboarding.problem1;

import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private final List<Page> pages;

    private Player(final List<Page> pages) {
        this.pages = pages;
    }

    public static Player from(final List<Integer> pageIndexes) {

        List<Page> pages = pageIndexes.stream()
            .map(Page::new)
            .collect(Collectors.toUnmodifiableList());

        return new Player(pages);
    }

    public boolean isValid() {

        if (!isValidSize()) {
            return false;
        }

        PagePair pagePair = new PagePair(pages.get(0), pages.get(1));
        return pagePair.isValidPair();
    }

    private boolean isValidSize() {
        return pages.size() == 2;
    }

    public int calculatePoint() {

        PagePair pagePair = new PagePair(pages.get(0), pages.get(1));
        return pagePair.findMaxPoint();
    }
}
