package onboarding.problem1.domain;

import java.util.Arrays;

public class Page {
    private final int page;
    
    public Page(final String page) {
        this(Integer.parseInt(page));
    }
    
    public Page(final int page) {
        this.page = page;
    }
    
    public int sumOfDigits() {
        return Arrays.stream(splitToStringPage())
                .mapToInt(Integer::parseInt)
                .sum();
    }
    
    private String[] splitToStringPage() {
        return String.valueOf(page).split("");
    }
}
