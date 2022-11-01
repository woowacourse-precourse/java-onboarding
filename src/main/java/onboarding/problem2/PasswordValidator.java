package onboarding.problem2;

import onboarding.problem2.exception.ExistUpperCaseException;
import onboarding.problem2.exception.PasswordOutOfSizeException;

public class PasswordValidator {
    private static final int MIN_PASSWORD_LENGTH = 1;
    private static final int MAX_PASSWORD_LENGTH = 1000;

    public void validate(String password) {
        validateUpperCase(password);
        validateLength(password);
    }

    private void validateLength(String password) {
        if (!isSatisfiedStringLength(password)) {
            throw new PasswordOutOfSizeException();
        }
    }

    private boolean isSatisfiedStringLength(String password) {
        int passwordLength = password.length();
        return passwordLength >= MIN_PASSWORD_LENGTH && passwordLength <= MAX_PASSWORD_LENGTH;
    }

    private void validateUpperCase(String password) {
        if(hasUpperCase(password)) {
            throw new ExistUpperCaseException();
        }
    }

    private boolean hasUpperCase(String password) {
        char[] passwordCharArr = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
            if(isUpperCase(passwordCharArr[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean isUpperCase(char passwordCharArr) {
        return passwordCharArr < 'a';
    }
}
