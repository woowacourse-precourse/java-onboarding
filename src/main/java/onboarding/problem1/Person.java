package onboarding.problem1;

import java.util.List;

public class Person {
    private Page pageOdd;
    private Page pageEven;

    public Person(List<Integer> pages) {
        pageOdd = new Page(pages.get(0));
        pageEven = new Page(pages.get(1));
    }

    public int getLargeValue() {
        if (pageOdd.getLargeValue() > pageEven.getLargeValue())
            return pageOdd.getLargeValue();
        return pageEven.getLargeValue();
    }
}
