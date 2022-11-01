package onboarding.problem1;

import onboarding.exception.ExceptionMessage;

public enum Problem1ExceptionMessage implements ExceptionMessage {
    NOT_VALID_BOOK_PAGE("책의 형식이 올바르지 않습니다.");

    private String message;

    Problem1ExceptionMessage(String message){
        this.message = message;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
}
