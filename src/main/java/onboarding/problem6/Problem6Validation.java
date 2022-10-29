package onboarding.problem6;

public class Problem6Validation {

    private final static String AT = "@";
    private final static String EMAIL_ENDS = "@email.com";

    public static boolean problem6Validation(String email, String nickname, int minEmailInput, int maxEmailInput, int minNicknameInput, int maxNicknameInput) {
        return problem6EmailNicknameValidation(email, nickname, minEmailInput, maxEmailInput, minNicknameInput, maxNicknameInput);

    }

    private static boolean problem6EmailNicknameValidation(String email, String nickname, int minEmailInput, int maxEmailInput, int minNicknameInput, int maxNicknameInput) {
        if (problem6InputLengthValidation(email, nickname, minEmailInput, maxEmailInput, minNicknameInput, maxNicknameInput)) {
            return problem6InputDetailValidation(email, nickname);
        } else {
            return false;
        }
    }

    private static boolean problem6InputLengthValidation(String email, String nickname, int minEmailInput, int maxEmailInput, int minNicknameInput, int maxNicknameInput) {
        return ((minEmailInput <= email.length() && email.length() <= maxEmailInput)
                && (minNicknameInput <= nickname.length() && nickname.length() <= maxNicknameInput));
    }

    private static boolean problem6InputDetailValidation(String email, String nickname) {
        return problem6EmailValidation(email) && problem6NicknameValidation(nickname);
    }

    private static boolean problem6EmailValidation(String email) {
        return atInEmailValidation(email) && dotComEmailValidation(email);
    }

    private static boolean atInEmailValidation(String email) {
        return email.chars()
                .filter(emailChar -> emailChar == AT.charAt(0))
                .count() == 1;
    }

    private static boolean dotComEmailValidation(String email) {
        return email.endsWith("@email.com");
    }

    private static boolean problem6NicknameValidation(String nickname) {
        return nickname.chars()
                .filter(nicknameChar -> Character.getType(nicknameChar) == 5)
                .count() == nickname.length();
    }
}
