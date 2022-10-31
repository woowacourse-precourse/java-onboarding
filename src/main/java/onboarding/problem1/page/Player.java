package onboarding.problem1.page;

import java.util.List;

public class Player {
    private final List<Integer> pages;

    Player(List<Integer> pages) {
        this.pages = pages;
    }

    public List<Integer> pages() {
        return pages;
    }
}
