package onboarding.feature1;

import java.util.List;

public class Pages {
    // 필드
    private final Integer leftPage;
    private final Integer rightPage;

    // 생성자
    public Pages(List<Integer> Pages) {
        this.leftPage = Pages.get(0);
        this.rightPage = Pages.get(1);
    }

    // 메소드
    public Integer getLeftPage() {
        return this.leftPage;
    }

    public Integer getRightPage() {
        return this.rightPage;
    }
}
