package onboarding.prob1.domain;

public class Player {

    private final Pages pages;
    private final SumCalculator sumCalculator = new SumCalculator();
    private final MultiplyCalculator multiplyCalculator = new MultiplyCalculator();

    public Player(Pages pages) {
        this.pages = pages;
    }

    public Integer getScore() {
        int a = sumCalculator.getScore(pages.getFirst(), pages.getSecond());
        int b = multiplyCalculator.getScore(pages.getFirst(), pages.getSecond());
        return Math.max(a, b);
    }


}
