package onboarding.problem1;

import java.util.List;

public class Page {

    private final int leftPage;
    private final int rightPage;

    public Page(List<Integer> pageList) {
        this.leftPage = pageList.get(0);
        this.rightPage = pageList.get(1);
    }

    public static Page create(List<Integer> pageList) {
        return new Page(pageList);
    }
}
