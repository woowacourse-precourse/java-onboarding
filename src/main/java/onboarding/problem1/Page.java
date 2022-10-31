package onboarding.problem1;

import java.util.List;

public class Page {

    private final Integer left;
    private final Integer right;

    public Page(List<Integer> input) {
        verifyInput(input);
        this.left = allocateLeftPage(input);
        this.right = allocateRightPage(input);
    }

    private void verifyInput(List<Integer> input) {
        verifyInputPageLength(input);
        verifyInputPageHasNull(input);
        verifyInputPageDifference(input);
    }

    private void verifyInputPageHasNull(List<Integer> input) {
        for (Integer pageNumber : input) {
            checkPageNumber(pageNumber);
        }
    }

    private void checkPageNumber(Integer pageNumber) {
        if(isNullPageNumber(pageNumber)) {
            throw new IllegalArgumentException("페이지는 null일 수 없습니다");
        }
    }

    private boolean isNullPageNumber(Integer pageNumber) {
        return pageNumber == null;
    }

    private void verifyInputPageDifference(List<Integer> input) {
        if ((input.get(1) - input.get(0) != 1)) {
            throw new IllegalArgumentException("오른쪽 페이지는 왼쪽 페이지보다 1 크다");
        }
    }

    private Integer allocateRightPage(List<Integer> input) {
        verifyRightPage(input);
        return input.get(1);
    }

    private void verifyRightPage(List<Integer> input) {
        if(isEvenNumber(input)) {
            throw new IllegalArgumentException("오른쪽 페이지는 짝수입니다.");
        }
    }

    private boolean isEvenNumber(List<Integer> input) {
        return input.get(1) % 2 != 0;
    }

    private Integer allocateLeftPage(List<Integer> input) {
        verifyLeftPage(input);
        return input.get(0);
    }

    private void verifyLeftPage(List<Integer> input) {
        if(isOddNumber(input)) {
            throw new IllegalArgumentException("왼쪽 페이지는 홀수입니다.");
        }
    }

    private boolean isOddNumber(List<Integer> input) {
        return input.get(0) % 2 != 1;
    }

    private void verifyInputPageLength(List<Integer> input) {
        if(isInputLengthTwo(input)) {
            throw new IllegalArgumentException("페이지는 왼쪽 오른쪽 두 개만 받을 수 있습니다.");
        }
    }

    private boolean isInputLengthTwo(List<Integer> input) {
        return input.size() != 2;
    }

    public Integer getLeftPage() {
        return this.left;
    }

    public Integer getRightPage() {
        return this.right;
    }
}
