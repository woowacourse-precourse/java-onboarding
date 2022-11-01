package onboarding.problem1.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class Player {
    private static final String NOT_FOUND_PAGE_EXCEPTION_MESSAGE = "페이지를 찾지 못했습니다.";
    private static final int RESULT_OF_EXCEPTION = -1;
    private static final int RESULT_OF_RIGHT_PLAYER_WIN = 2;
    
    private final Page leftPage;
    private final Page rightPage;
    
    public Player(final int leftPage, final int rightPage) {
        this(new Page(leftPage), new Page(rightPage));
    }
    
    public Player(List<Page> pages) {
        this(pages.get(0), pages.get(1));
    }
    
    public Player(final Page leftPage, final Page rightPage) {
        this.leftPage = leftPage;
        this.rightPage = rightPage;
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
        return leftPage.isExceededRange() || rightPage.isExceededRange();
    }
    
    private boolean isPlayersLeftBigger(final Player rightPlayer) {
        return isLeftBigger() || rightPlayer.isLeftBigger();
    }
    
    private boolean isLeftBigger() {
        return leftPage.isBigger(rightPage);
    }
    
    private boolean isPlayersDifferenceNotOne(final Player rightPlayer) {
        return isDifferenceNotOne() || rightPlayer.isDifferenceNotOne();
    }
    
    private boolean isDifferenceNotOne() {
        return leftPage.isDifferenceNotOne(rightPage);
    }
    
    private boolean isPlayersNotCorrectEvenAndOddNumber(final Player rightPlayer) {
        return isNotCorrectEvenAndOddNumbers() || rightPlayer.isNotCorrectEvenAndOddNumbers();
    }
    
    private boolean isNotCorrectEvenAndOddNumbers() {
        return leftPage.isNotOdd() || rightPage.isNotEven();
    }
    
    private int getMaxNumber() {
        return Math.max(getMaxSum(), getMaxMultiply());
    }
    
    private int getMaxSum() {
        return Stream.of(leftPage, rightPage)
                .mapToInt(Page::sumOfDigits)
                .max()
                .orElseThrow(() -> new NoSuchElementException(NOT_FOUND_PAGE_EXCEPTION_MESSAGE));
    }
    
    private int getMaxMultiply() {
        return Stream.of(leftPage, rightPage)
                .mapToInt(Page::multiplyOfDigits)
                .max()
                .orElseThrow(() -> new NoSuchElementException(NOT_FOUND_PAGE_EXCEPTION_MESSAGE));
    }
}
