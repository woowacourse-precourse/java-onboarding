package onboarding.problem1;

public class PagePair {

    private final Page left;
    private final Page right;

    public PagePair(final Page left, final Page right) {
        this.left = left;
        this.right = right;
    }

    public boolean isValidPair() {

        return left.isValidLeftPage()
            && right.isValidRightPage()
            && right.isPlacedRightAfter(left);
    }

    public int findMaxPoint() {

        return Math.max(
            left.findMaxValue(),
            right.findMaxValue()
        );
    }
}
