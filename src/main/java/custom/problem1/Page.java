package custom.problem1;


/**
 *  > BookPages의 원시 객체
 */
public class Page {

    private final int value;
    private final Status status;

    public Page(int page, Status status) {
        if (Status.LEFT.equals(status) && !isOdd(page)) {
            throw new RuntimeException("페이지 왼쪽 값은 홀수여야 합니다");
        }
        if (Status.RIGHT.equals(status) && !isEven(page)) {
            throw new RuntimeException("페이지 오른쪽 값은 짝우여야 합니다");
        }
        this.value = page;
        this.status = status;
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    public int getValue() {
        return value;
    }

    public Status getStatus() {
        return status;
    }
}
