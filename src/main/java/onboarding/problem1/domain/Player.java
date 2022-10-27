package onboarding.problem1.domain;

public class Player {
    private final Pages pages;
    
    public Player(final int leftPage, final int rightPage) {
        this.pages = new Pages(leftPage, rightPage);
    }
    
    public int getMaxSumOfPlayer() {
        return pages.getMaxSum();
    }
}
