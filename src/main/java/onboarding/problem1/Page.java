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

    private int multiply(int num) {
        int result = 1;
        while (num > 0) {
            result *= num % 10;
            num /= 10;
        }
        return result;
    }

    private int add(int num) {
        int result = 0;
        while ( num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    private int getAddMax(int left, int right) {
        if (add(left) > add(right)){
            return add(left);
        } else{
            return add(right);
        }
    }

    private int getMultiplyMax(int left, int right) {
        if (multiply(left) > multiply(right)){
            return multiply(left);
        } else{
            return multiply(right);
        }
    }

    public int getScore(){
        if (getAddMax(this.getLeft(), this.getRight()) > getMultiplyMax(this.getLeft(), this.getRight())) {
            return getAddMax(this.getLeft(), this.getRight());
        } else{
            return getMultiplyMax(this.getLeft(), this.getRight());
        }
    }
}
