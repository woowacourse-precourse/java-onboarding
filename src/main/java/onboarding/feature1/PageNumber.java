package onboarding.feature1;

import java.util.List;

public class PageNumber {
    // 필드
    private final Integer leftPage;
    private final Integer rightPage;

    // 생성자
    public PageNumber(List<Integer> PageNumbers) {
        this.leftPage = PageNumbers.get(0);
        this.rightPage = PageNumbers.get(1);
    }

    // 메소드
    public Integer getLeftPage() {
        return this.leftPage;
    }

    public Integer getRightPage() {
        return this.rightPage;
    }
}
