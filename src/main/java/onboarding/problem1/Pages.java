package onboarding.problem1;

public class Pages {
    private final int page1;
    private final int page2;

    public Pages(int page1, int page2) {
        // Assert args
        if (!(page1 >= 1 && page1 <= 399)) {
            throw new IllegalArgumentException("페이지 값은 다음과 같은 조건을 만족해야 합니다 : 1 <= page1 <= 309");
        } else if (!(page1%2 == 1 && page2 == page1+1)) {
            throw new IllegalArgumentException("페이지 값은 다음과 같은 조건을 만족해야 합니다 : page1 = 홀수, page2 = page1 + 1");
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
