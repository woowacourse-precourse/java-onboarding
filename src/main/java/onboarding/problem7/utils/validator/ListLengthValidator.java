package onboarding.problem7.utils.validator;

import onboarding.problem7.utils.validator.exception.ListLengthException;
import java.util.List;

public class ListLengthValidator {
    List<String> stringList;


    public ListLengthValidator(List<String> list, int min, int max) throws ListLengthException{
        this.stringList = list;
        validateListLength(min, max);
    }

    private void validateListLength(int min, int max) throws ListLengthException {
        int length = stringList.size();
        if(length < min || length > max){
            throw new ListLengthException("배열 범위 초과! 최소: " +min +" 최대: "+max);
        }
    }
}
