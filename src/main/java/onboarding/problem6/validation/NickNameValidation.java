package onboarding.problem6.validation;

public class NickNameValidation {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 19;
    private static final String NICK_NAME_REGEXP = "^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+$";
    private static final String NAME_LANGUAGE_EXCEPTION_MESSAGE = "닉네임은 한글만 가능합니다.";
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "닉네임은 1자 이상 20자 미만이어야 합니다.";

    public static void validate(String nickName) {
        validateNickNameLanguage(nickName);
        validateNickNameLength(nickName);
    }

    private static void validateNickNameLanguage(String nickName) {
        if (!nickName.matches(NICK_NAME_REGEXP)) {
            throw new IllegalArgumentException(NAME_LANGUAGE_EXCEPTION_MESSAGE);
        }
    }
    private static void validateNickNameLength(String nickName) {
        if ((nickName.length() > MAX_NAME_LENGTH) || (nickName.length() < MIN_NAME_LENGTH)) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
