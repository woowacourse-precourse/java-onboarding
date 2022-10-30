package onboarding.problem1;

import java.util.List;

class PageOperator {
    private Integer getMultiply(Integer pageNumber) {
        Integer mul = 1;
        while (pageNumber > 0) {
            mul *= pageNumber % 10;
            pageNumber /= 10;
        }
        return mul;
    }

    private Integer getSum(Integer pageNumber) {
        Integer sum = 0;
        while (pageNumber > 0) {
            sum += pageNumber % 10;
            pageNumber /= 10;
        }
        return sum;
    }

    private Integer getMaxNumber(Integer pageNumber) {
        Integer multiplyResult = getMultiply(pageNumber);
        Integer sumResult = getSum(pageNumber);
        return multiplyResult > sumResult ? multiplyResult : sumResult;
    }

    public Integer getMaxPageNumber(List<Integer> pages) {
        return pages.stream().map(this::getMaxNumber)
                .max((page1, page2) -> page1 < page2 ? page1 : page2).get();
    }
}
