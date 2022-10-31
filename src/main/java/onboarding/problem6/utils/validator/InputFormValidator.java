package onboarding.problem6.utils.validator;

import onboarding.problem6.utils.validator.exception.InputFormException;
import java.util.List;

public class InputFormValidator {
    public InputFormValidator(List<List<String>> form) throws InputFormException {
        try{
            new CrewFormsLengthValidator(form);
            new EmailFormValidator(form);
            new EmailLengthValidator(form);
            new EmailDomainValidator(form);
            new NotHangulNicknameValidator(form);
            new NicknameLengthValidator(form);
        }catch (Exception e){
            e.printStackTrace();
            throw new InputFormException("잘못된 신청 양식");
        }
    }
}
