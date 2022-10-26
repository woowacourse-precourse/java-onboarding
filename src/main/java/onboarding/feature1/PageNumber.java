package onboarding.feature1;

import java.util.List;

public class PageNumber {
    // 필드
    private final Integer leftPage;
    private final Integer rightPage;

    // 생성자
    public PageNumber(List<Integer> numbers) {
        this.leftPage = numbers.get(0);
        this.rightPage = numbers.get(1);
    }

    // 메소드
    public int getLeftPage() {
        return this.leftPage;
    }

    public int getRightPage() {
        return this.rightPage;
    }
}
