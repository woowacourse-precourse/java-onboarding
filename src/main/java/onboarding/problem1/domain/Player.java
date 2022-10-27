package onboarding.problem1.domain;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Player {
    private static final String NOT_FOUND_PAGE_EXCEPTION_MESSAGE = "페이지를 찾지 못했습니다.";
    
    private final List<Page> pages;
    
    public Player(final int leftPage, final int rightPage) {
        this(new Page(leftPage), new Page(rightPage));
    }
    
    public Player(final Page leftPage, final Page rightPage) {
        this(Arrays.asList(leftPage, rightPage));
    }
    
    public Player(final List<Page> pages) {
        this.pages = pages;
    }
    
    public int compareTo(final Player rightPlayer) {
        final int resultOfCompare = Integer.compare(getMaxNumber(), rightPlayer.getMaxNumber());
        if (resultOfCompare < 0) {
            return 2;
        }
        
        return resultOfCompare;
    }
    
    private int getMaxNumber() {
        return Math.max(getMaxSum(), getMaxMultiply());
    }
    
    private int getMaxSum() {
        return pages.stream()
                .mapToInt(Page::sumOfDigits)
                .max()
                .orElseThrow(() -> new NoSuchElementException(NOT_FOUND_PAGE_EXCEPTION_MESSAGE));
    }
    
    private int getMaxMultiply() {
        return pages.stream()
                .mapToInt(Page::multiplyOfDigits)
                .max()
                .orElseThrow(() -> new NoSuchElementException(NOT_FOUND_PAGE_EXCEPTION_MESSAGE));
    }
}
