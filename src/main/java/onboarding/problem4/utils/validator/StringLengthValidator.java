package onboarding.problem4.utils.validator;

import onboarding.problem4.utils.Constants;
import onboarding.problem4.utils.validator.exception.StringLengthException;

public class StringLengthValidator {

    private final String word;
    private final int least = Constants.LEASTWORDLENGTH;
    private final int maximum = Constants.MAXIMUMLENGTH;

    public StringLengthValidator(String word) throws StringLengthException {
        this.word = word;
        validateStringLengthOver();
    }

    private void validateStringLengthOver() throws StringLengthException{
        if(((word.length()<least) || (word.length() > maximum))){
            throw new StringLengthException("제한된 길이에 맞지않음");
        }
    }
}
