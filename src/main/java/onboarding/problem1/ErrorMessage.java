package onboarding.problem1;

public enum ErrorMessage {
    MESSAGE("[ERROR] %s"),
    PAGE_GAP("pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다."),
    PAGE_ODD_AND_EVEN("왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이다."),
    LENGTH("pobi와 crong의 길이는 2이다."),
    PAGE_RANGE("1부터 시작되는 400 페이지의 책입니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
