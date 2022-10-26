package onboarding.feature1;

import java.util.List;

public class PageNumber {
    // 필드
    private final int leftPageNumber;
    private final int rightPageNumber;

    // 생성자
    public PageNumber(List<Integer> numbers) {
        this.leftPageNumber = numbers.get(0);
        this.rightPageNumber = numbers.get(1);
    }

    // 메소드
    public int getLeftPageNumber() {
        return this.leftPageNumber;
    }

    public int getRightPageNumber() {
        return this.rightPageNumber;
    }
}
