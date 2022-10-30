package onboarding.problem1;

public class Pages {

    private Page leftPage;
    private Page rightPage;

    public Pages(int left, int right) {

        Page leftPage = new Page(left);
        Page rightPage = new Page(right);

        validatePages(leftPage, rightPage);
        this.leftPage = leftPage;
        this.rightPage = rightPage;
    }

    private void validatePages(Page leftPage, Page rightPage) {
        IllegalArgumentException exception = new IllegalArgumentException("Invalid pages");

        if (!rightPage.isNextPageOf(leftPage)) throw exception;

        if (leftPage.isEven() || rightPage.isOdd()) throw exception;
    }

    private int getMaxSum() {
        return Math.max(leftPage.getSum(), rightPage.getSum());
    }

    private int getMaxProduct() {
        return Math.max(leftPage.getProduct(), rightPage.getProduct());
    }

    public int getScore() {
        return Math.max(getMaxSum(), getMaxProduct());
    }
}

