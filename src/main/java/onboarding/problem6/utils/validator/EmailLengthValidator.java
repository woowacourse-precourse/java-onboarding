package onboarding.problem6.utils.validator;

import onboarding.problem6.utils.Constants;
import onboarding.problem6.utils.validator.exception.EmailLengthException;

import java.util.List;

public class EmailLengthValidator {
    private List<List<String>> form;

    public EmailLengthValidator(List<List<String>> form) throws EmailLengthException{
        this.form = form;
        validateAllEmailLength();
    }

    private void validateAllEmailLength() throws EmailLengthException{
        for (List<String> crew: form){
            validateEmailLength(crew);
        }
    }

    private void validateEmailLength(List<String> crew) throws EmailLengthException{
        int crewEmailLength = crew.get(Constants.CERW_EMAIL).length();
        if(crewEmailLength < Constants.MIN_EMAIL_LENGTH || crewEmailLength > Constants.MAX_EMAIL_LENGTH){
            throw new EmailLengthException("이메일 길이가 초과된 크루 존재");
        }
    }
}
