package onboarding.problem1;

public class Page {
    private int left;
    private int right;

    public Page(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public boolean isValidLeft(int left) {
        return left % 2 == 1;
    }

    public boolean isValidRight(int right) {
        return right % 2 == 0;
    }

    public boolean isBetween(int start, int end) {
        return start <= left & right <= end;
    }
}
