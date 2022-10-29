package onboarding.problem2.utils.validator;

import onboarding.problem2.utils.validator.exception.StringLengthException;

public class StringLengthValidator {

    private String word;
    private int least;
    private int maximum;

    public StringLengthValidator(String word, int least, int maximum) throws StringLengthException {
        this.word = word;

    }

    private void validateStringLengthOver() throws StringLengthException{
        if((word.length()<least) || (word.length() > maximum)){
            throw new StringLengthException("제한된 길이에 맞지않음");
        }
    }
}
