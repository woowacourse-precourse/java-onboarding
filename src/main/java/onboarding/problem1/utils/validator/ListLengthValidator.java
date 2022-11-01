package onboarding.problem1.utils.validator;

import java.util.List;
import onboarding.problem1.utils.Constants;
import onboarding.problem1.utils.validator.exception.MaxArrayLengthException;

public class ListLengthValidator {
    private List<Integer> list;

    public ListLengthValidator(List<Integer> list) throws MaxArrayLengthException {
        this.list = list;
        validateMaxLengthOver();
    }

    private void validateMaxLengthOver() throws MaxArrayLengthException {
        if(list.size() > Constants.MAX_ARRAY_LENGTH) {
            throw new MaxArrayLengthException("최대 배열 크기를 넘김");
        }
    }
}