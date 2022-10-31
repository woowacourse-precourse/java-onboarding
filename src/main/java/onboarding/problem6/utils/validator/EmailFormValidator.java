package onboarding.problem6.utils.validator;

import onboarding.problem6.utils.Constants;
import onboarding.problem6.utils.validator.exception.EmailFormException;

import java.util.List;
import java.util.regex.Pattern;

public class EmailFormValidator {
    private List<List<String>> form;

    public EmailFormValidator(List<List<String>> form) throws EmailFormException{
        this.form = form;
        validateAllEmailForm();
    }
    private void validateAllEmailForm() throws EmailFormException{
        for(List<String> crew : form){
            validateEmailForm(crew);
        }
    }

    private void validateEmailForm(List<String> crew) throws EmailFormException{
       if(!Pattern.matches(Constants.EMAIL_REGEX, crew.get(Constants.CERW_EMAIL))){
           throw new EmailFormException("신청자 중에 이메일 형식이 다른 크루가 있음");
       }
    }

}
