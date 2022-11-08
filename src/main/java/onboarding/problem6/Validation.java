package onboarding.problem6;

import java.util.List;

import static java.util.regex.Pattern.matches;

public class Validation {
    private static final String emailRegex = "^([a-zA-Z0-9\\s]*@gmail.com)$";
    private static final String nicknameRegex = "^([ㄱ-ㅎㅏ-ㅣ가-힣]*)$";

    public static boolean isCrewOutOfRange(List<List<String>> forms) {
        int count = 0;

        for (List<String> ignored : forms) {
            count++;
        }

        return count < 1 || count > 10000;
    }

    public static boolean isEmailOutOfRange(List<String> emailForms) {
        boolean isOutOfRange = false;

        for (String emailForm : emailForms) {
            isOutOfRange = isOutOfRange || emailForm.length() < 11 || emailForm.length() > 20;
        }

        return isOutOfRange;
    }

    public static boolean isNicknameOutOfRange(List<String> nicknameForms) {
        boolean isOutOfRange = false;

        for (String nicknameForm : nicknameForms) {
            isOutOfRange = isOutOfRange || nicknameForm.length() < 1 || nicknameForm.length() > 20;
        }

        return isOutOfRange;
    }

    public static boolean isInvalidEmailForm(List<String> emailForms) {
        boolean isInvalidForm = false;

        for (String emailForm : emailForms) {
            isInvalidForm = isInvalidForm || matches(emailRegex, emailForm);
        }

        return isInvalidForm;
    }

    public static boolean isInvalidNicknameForm(List<String> nicknameForms) {
        boolean isInvalidForm = false;

        for (String nicknameForm : nicknameForms) {
            isInvalidForm = isInvalidForm || !matches(nicknameRegex, nicknameForm);
        }

        return isInvalidForm;
    }
}
