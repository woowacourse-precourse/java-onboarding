package onboarding.problem1.exception;

public enum OpenBookPageValid {
    PAGE_OVER("정해진 페이지를 초과되었습니다."),
    PAGE_NOT_SIDE_BY_SIDE("페이지가 나란히 있지 않습니다."),
    BAD_PAGE_ODD_SETTING("페이지 홀수 배치가 잘못되었습니다."),
    BAD_PAGE_EVEN_SETTING("페이지 짝수 배치가 잘못되었습니다.")
    ;

    private final String message;

    OpenBookPageValid(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
