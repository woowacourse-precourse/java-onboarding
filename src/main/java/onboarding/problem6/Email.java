package onboarding.problem6;

import onboarding.exception.InputException;
import onboarding.problem6.exception.Problem6ExceptionMessage;

import java.util.regex.Pattern;

public class Email {

    private static final String ALLOWED_DOMAIN_FRONT = "email";
    private static final String ALLOWED_DOMAIN_BACK = "com";

    private static final String EMAIL_REGULAR_EXPRESSION = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-z]+$";
    private static final String DOMAIN_MATCH_REGULAR_EXPRESSION
            = "^.+" + ALLOWED_DOMAIN_FRONT + "\\." + ALLOWED_DOMAIN_BACK + "$";

    private String email;

    public Email(String email){
        this.email = email;
        checkEmailIsVerified();
    }

    public String getEmail() {
        return email;
    }

    private void checkEmailIsVerified(){
        if (!isEmailForm())
            throw new InputException(Problem6ExceptionMessage.NOT_EMAIL_FORM);
        if (!isNumberOfCharacterFrom11to20())
            throw new InputException(Problem6ExceptionMessage.NOT_EMAIL_LENGTH_ALLOWED);
        if (!isDomainAllowed())
            throw new InputException(Problem6ExceptionMessage.NOT_ALLOWED_DOMAIN);
    }

    private boolean isEmailForm(){
        return Pattern.compile(EMAIL_REGULAR_EXPRESSION).matcher(email).matches();
    }

    private boolean isNumberOfCharacterFrom11to20() {
        return 11 <= email.length() && email.length() <= 20;
    }

    private boolean isDomainAllowed(){
        return Pattern.compile(DOMAIN_MATCH_REGULAR_EXPRESSION).matcher(email).matches();
    }
}
