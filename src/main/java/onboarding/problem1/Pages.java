package onboarding.problem1;

public class Pages {
    private int page1;
    private int page2;

    public Pages(int page1, int page2) {
        // Assert args
        if(!(page1 >= 1 && page1%2 == 1 && page2 == page1+1)) {
            throw new PagesIllegalPageNumber();
        }

        this.page1 = page1;
        this.page2 = page2;
    }

    public int getPage1() {
        return page1;
    }

    public int getPage2() {
        return page2;
    }
}
