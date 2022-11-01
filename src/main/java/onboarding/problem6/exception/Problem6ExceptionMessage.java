package onboarding.problem6.exception;

import onboarding.exception.ExceptionMessage;

public enum Problem6ExceptionMessage implements ExceptionMessage {
    NOT_EMAIL_FORM("이메일 형식이 지켜지지 않았습니다."),
    NOT_ALLOWED_DOMAIN("허용된 도메인을 사용하지 않았습니다."),
    NOT_EMAIL_LENGTH_ALLOWED("이메일은 11 ~ 20자 이어야 합니다."),
    NOT_NICKNAME_ALLOWED("닉네임이 한글이며 1~20자 사이이지 않습니다."),
    NOT_FORM_MATCHED("입력된 크루의 정보 형식이 일치하지 않습니다."),
    NUMBER_OF_CREW_NOT_ALLOWED("크루의 수가 1명 미만이거나 10,000명 초과입니다.");

    private final String errorMessage;

    Problem6ExceptionMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
