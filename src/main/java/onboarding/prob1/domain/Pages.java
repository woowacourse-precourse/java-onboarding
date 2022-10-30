package onboarding.prob1.domain;

import java.util.List;

public class Pages {
    private final List<Integer> pages;

    private Pages(List<Integer> pages) {
        this.pages = pages;
    }

    public static Pages of(final List<Integer> pages) {
        Integer first = pages.get(0);
        Integer second = pages.get(1);
        if (first.equals(1)) throw new RuntimeException();
        if (first.equals(400)) throw new RuntimeException();
        if (second.equals(1)) throw new RuntimeException();
        if (second.equals(400)) throw new RuntimeException();
        if (first > second) throw new RuntimeException();
        if (second > first + 1) throw new RuntimeException();
        if ( (first % 2) == 0) throw new RuntimeException();
        if ( (second % 2) != 0) throw new RuntimeException();
        return new Pages(pages);
    }

    public Integer getFirst() {
        return pages.get(0);
    }

    public Integer getSecond() {
        return pages.get(1);
    }
}
