package Problem1;

public class Page {
    private int leftPage;
    private int rightPage;

    public Page(int leftPage, int rightPage) {
        this.leftPage = leftPage;
        this.rightPage = rightPage;
    }

    public boolean checkPage() {
        return isRightRange(leftPage) && isRightRange(rightPage)
                && !isEven(leftPage) && isEven(rightPage)
                && isNext();
    }

    private boolean isNext() {
        return leftPage + 1 == rightPage;
    }

    private boolean isEven(int page) {
        return page % 2 == 0;
    }

    private boolean isRightRange(int page) {
        return page >= 3 && page <= 398;
    }
}
