package onboarding.problem6;

import onboarding.problem6.exception.FieldLengthOutOfSizeException;
import onboarding.problem6.exception.NotAllowDomainException;
import onboarding.problem6.exception.NotEmailFormException;

public class CrewValidator {
    private static final int MIN_NICKNAME_LENGTH = 1;
    private static final int MAX_NICKNAME_LENGTH = 19;

    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 19;

    public void validate(Crew crew) {
        validateEmail(crew.getEmail());
        validateNickname(crew.getNickname());
    }
    private void validateEmail(String email) {
        validateStringLength(email, MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);
        validateEmailFormat(email);
        validateAllowDomain(email.split("@")[1]);
    }

    private void validateEmailFormat(String email) {
        if(!isEmailFormat(email)) {
            throw new NotEmailFormException();
        }
    }

    private void validateAllowDomain(String domain) {
        if(!isAllowDomain(domain)) {
            throw new NotAllowDomainException();
        }
    }

    private void validateNickname(String nickname) {
        validateStringLength(nickname, MIN_NICKNAME_LENGTH, MAX_NICKNAME_LENGTH);
    }

    private void validateStringLength(String str, int minLength, int maxLength) {
        if(str.length() < minLength || str.length() > maxLength) {
            throw new FieldLengthOutOfSizeException(str);
        }
    }
    private boolean isEmailFormat(String email) {
        final String EMAIL_REGEX = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        return email.matches(EMAIL_REGEX);
    }

    private boolean isAllowDomain(String domain) {
        final String EMAIL_DOMAIN = "email.com";
        return domain.equals(EMAIL_DOMAIN);
    }

}
