package onboarding.problem1;

public class PagePlayer {
    private Pages pages;
    private int score;

    public PagePlayer(Pages pages) {
        this.pages=pages;
        this.score= pages.calculateScore();
    }


}
