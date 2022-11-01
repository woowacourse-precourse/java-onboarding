package onboarding.problem1.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Page {
    private static final String NOT_FOUND_PAGE_EXCEPTION_MESSAGE = "페이지를 찾지 못했습니다.";
    private static final int MIN_PAGE = 3;
    private static final int MAX_PAGE = 398;
    private static final String DELIMITER = "";
    
    private final int page;
    
    public Page(final int page) {
        this.page = page;
    }
    
    public int sumOfDigits() {
        return Arrays.stream(splitToStringPage())
                .mapToInt(Integer::parseInt)
                .sum();
    }
    
    public int multiplyOfDigits() {
        return Arrays.stream(splitToStringPage())
                .mapToInt(Integer::parseInt)
                .reduce((cumulativeNumber, digit) -> cumulativeNumber * digit)
                .orElseThrow(() -> new NoSuchElementException(NOT_FOUND_PAGE_EXCEPTION_MESSAGE));
    }
    
    private String[] splitToStringPage() {
        final String stringPage = String.valueOf(page);
        return stringPage.split(DELIMITER);
    }
    
    public boolean isNotOdd() {
        return page % 2 != 1;
    }
    
    public boolean isNotEven() {
        return page % 2 != 0;
    }
    
    public boolean isDifferenceNotOne(final Page page) {
        return Math.abs(this.page - page.page) != 1;
    }
    
    public boolean isBigger(final Page page) {
        return this.page > page.page;
    }
    
    public boolean isExceededRange() {
        return page < MIN_PAGE || page > MAX_PAGE;
    }
}
