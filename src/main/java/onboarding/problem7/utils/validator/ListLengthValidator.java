package onboarding.problem7.utils.validator;

import onboarding.problem7.utils.validator.exception.ListLengthException;
import java.util.List;

public class ListLengthValidator {
    List<Object> list;

    public ListLengthValidator(List<Object> list, int min, int max) throws ListLengthException{
        this.list = list;
        validateListLength(min, max);
    }

    private void validateListLength(int min, int max) throws ListLengthException {
        int length = list.size();
        if(length < min || length > max){
            throw new ListLengthException("배열 범위 초과! 최소: " +min +" 최대: "+max);
        }
    }
}
