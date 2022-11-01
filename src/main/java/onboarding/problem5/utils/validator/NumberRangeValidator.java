package onboarding.problem5.utils.validator;

import onboarding.problem5.utils.Constants;
import onboarding.problem5.utils.validator.exception.NumberRangeException;

public class NumberRangeValidator {
    private int number;

    public NumberRangeValidator(int number) throws NumberRangeException{
        this.number = number;
        validateNumberRange();
    }

    private void validateNumberRange() throws NumberRangeException{
        if(!((number>= Constants.MINMONEY) && (number <= Constants.MAXMONEY))){
            throw new NumberRangeException("숫자의 범위 초과");
        }
    }
}
