package onboarding.problem6.utils.validator;

import onboarding.problem6.utils.Constants;
import onboarding.problem6.utils.validator.exception.CrewFormsLengthException;

import java.util.List;

public class CrewFormsLengthValidator {
    private List<List<String>> form;

    public CrewFormsLengthValidator(List<List<String>> forms) throws CrewFormsLengthException{
        this.form = forms;
        validateCrewFormsLength();
    }
    private void validateCrewFormsLength() throws CrewFormsLengthException{
        int formLength = form.size();
        if(formLength < Constants.MIN_CREW_NUMBER || formLength > Constants.MAX_CREW_NUMBER){
            throw new CrewFormsLengthException("최대 인원을 넘김");
        }
    }
}
