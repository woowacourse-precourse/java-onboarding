package onboarding.problem1.domain;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Player {
    private static final String NOT_FOUND_PAGE_EXCEPTION_MESSAGE = "페이지를 찾지 못했습니다.";
    private static final int RESULT_OF_EXCEPTION = -1;
    private static final int RESULT_OF_RIGHT_PLAYER_WIN = 2;
    
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
        if (isNotCorrectPages(rightPlayer)) {
            return RESULT_OF_EXCEPTION;
        }
        final int resultOfCompare = Integer.compare(getMaxNumber(), rightPlayer.getMaxNumber());
        
        if (isRightPlayerVictory(resultOfCompare)) {
            return RESULT_OF_RIGHT_PLAYER_WIN;
        }
        return resultOfCompare;
    }
    
    private boolean isRightPlayerVictory(final int resultOfCompare) {
        return resultOfCompare < 0;
    }
    
    private boolean isNotCorrectPages(final Player rightPlayer) {
        return isPlayersNotCorrectEvenAndOddNumber(rightPlayer) || isPlayersDifferenceNotOne(rightPlayer) || isPlayersLeftBigger(rightPlayer)
                || isPlayersExceededRange(rightPlayer);
    }
    
    private boolean isPlayersExceededRange(final Player rightPlayer) {
        return isExceededRange() || rightPlayer.isExceededRange();
    }
    
    private boolean isExceededRange() {
        return pages.get(0).isExceededRange() || pages.get(1).isExceededRange();
    }
    
    private boolean isPlayersLeftBigger(final Player rightPlayer) {
        return isLeftBigger() || rightPlayer.isLeftBigger();
    }
    
    private boolean isLeftBigger() {
        return pages.get(0).isBigger(pages.get(1));
    }
    
    private boolean isPlayersDifferenceNotOne(final Player rightPlayer) {
        return isDifferenceNotOne() || rightPlayer.isDifferenceNotOne();
    }
    
    private boolean isDifferenceNotOne() {
        return pages.get(0).isDifferenceNotOne(pages.get(1));
    }
    
    private boolean isPlayersNotCorrectEvenAndOddNumber(final Player rightPlayer) {
        return isNotCorrectEvenAndOddNumbers() || rightPlayer.isNotCorrectEvenAndOddNumbers();
    }
    
    private boolean isNotCorrectEvenAndOddNumbers() {
        return pages.get(0).isNotOdd() || pages.get(1).isNotEven();
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
