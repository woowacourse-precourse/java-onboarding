package onboarding.problem6.exception;

import onboarding.exception.ExceptionMessage;

public enum Problem6ExceptionMessage implements ExceptionMessage {
    NOT_EMAIL_FORM("이메일 형식이 지켜지지 않았습니다."),
    NOT_ALLOWED_DOMAIN("허용된 도메인을 사용하지 않았습니다."),
    NOT_NICKNAME_ALLOWED("닉네임이 한글이며 1~20자 사이이지 않습니다.");

    private final String errorMessage;

    Problem6ExceptionMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
