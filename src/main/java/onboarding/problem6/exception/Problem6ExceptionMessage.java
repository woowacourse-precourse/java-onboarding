package onboarding.problem6.exception;

import onboarding.exception.ExceptionMessage;

public enum Problem6ExceptionMessage implements ExceptionMessage {
    NOT_EMAIL_FORM("이메일 형식이 아닙니다."),
    NOT_ALLOWED_DOMAIN("허용된 도메인이 아닙니다.");

    private final String errorMessage;

    Problem6ExceptionMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
