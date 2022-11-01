package onboarding.problem3.utils.validator;

import onboarding.problem3.utils.validator.Exception.NumberRangeException;

public class NumberRangeValidator {
    private int number;
    private int least=1;
    private int maximum=1000;

    public NumberRangeValidator(int number) throws NumberRangeException{
        this.number = number;
        validateNumberRange();
    }

    private void validateNumberRange() throws NumberRangeException{
        if(!((number>=least) && (number <= maximum))){
            throw new NumberRangeException("숫자의 범위 초과");
        }
    }
}
