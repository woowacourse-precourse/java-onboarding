package onboarding.problem6.utils.validator;

import onboarding.problem6.utils.Constants;
import onboarding.problem6.utils.validator.exception.EmailDomainException;

import java.util.List;

public class EmailDomainValidator {
    private List<List<String>> form;

    public EmailDomainValidator(List<List<String>> form) throws EmailDomainException{
        this.form = form;
        validateAllCrewEmailDomain();
    }

    private void validateAllCrewEmailDomain() throws EmailDomainException{
        for(List<String> crew : form){
            validateCrewEmailDomain(crew);
        }
    }

    private void validateCrewEmailDomain(List<String> crew) throws EmailDomainException{
        String crewEmail = crew.get(Constants.CERW_EMAIL);
        if(!(getDomain(crewEmail).equals(Constants.DOMAIN))){
            throw new EmailDomainException("이메일 도메인이 맞지 않는 크루가 있음");
        }
    }

    private String getDomain(String email){
        return email.substring(email.length()-Constants.DOMAIN_POSITION);
    }
}
