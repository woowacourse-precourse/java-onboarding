package onboarding.problem2.utils.validator;

import onboarding.problem2.utils.validator.exception.InvalidStringException;

public class InvalidStringValidator {
    public InvalidStringValidator(String text) throws InvalidStringException {
        try{
            new StringLengthValidator(text, 1, 1000);
            new NotLowerEnglishValidator(text);
        }catch (Exception e){
            e.printStackTrace();
            throw new InvalidStringException("옳바르지 않은 문자열 입력");
        }
    }
}
