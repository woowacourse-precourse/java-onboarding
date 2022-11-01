package onboarding.problem6.exception;

public class FieldLengthOutOfSizeException extends RuntimeException {
    private static final String MESSAGE = "입력값의 길이가 기준에 부합하지 않습니다. 입력값 : ";

    public FieldLengthOutOfSizeException(String fieldValue) {
        super(MESSAGE+fieldValue);
    }
}
