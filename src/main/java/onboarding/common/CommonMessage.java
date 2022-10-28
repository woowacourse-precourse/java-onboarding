package onboarding.common;

public enum CommonMessage {

    PERMIT_ONLY_LOWERCASE("문자는 소문자만 입력해야 합니다.");

    private final String message;

    CommonMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
