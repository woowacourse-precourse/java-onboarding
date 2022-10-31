package onboarding.problem6;

import onboarding.validation.MinMaxInputValidatable;

import static onboarding.validation.MinMaxIntegerInputValidate.getMinMaxIntegerInputValidate;
import static onboarding.validation.MinMaxStringInputValidate.getMinMaxStringInputValidate;

public class Problem6Validation {

    private static final String AT = "@";
    private static final String EMAIL_ENDS = "@email.com";

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
        MinMaxInputValidatable minMaxInputValidator = getMinMaxStringInputValidate();
        return minMaxInputValidator.isInputBetweenMinAndMax(email, minEmailInput, maxEmailInput) && minMaxInputValidator.isInputBetweenMinAndMax(nickname, minNicknameInput, maxNicknameInput);
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
        return email.endsWith(EMAIL_ENDS);
    }

    private static boolean problem6NicknameValidation(String nickname) {
        return nickname.chars()
                .filter(nicknameChar -> Character.getType(nicknameChar) == Character.OTHER_LETTER)
                .count() == nickname.length();
    }
}
