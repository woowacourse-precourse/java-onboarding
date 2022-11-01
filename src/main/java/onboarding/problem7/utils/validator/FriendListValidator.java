package onboarding.problem7.utils.validator;

import onboarding.problem7.utils.validator.exception.ListLengthException;

import java.util.List;

public class FriendListValidator {
    List<List<String>> list;


    public FriendListValidator(List<List<String>> list, int min, int max) throws ListLengthException {
        this.list = list;
        validateListLength(min, max);
    }

    private void validateListLength(int min, int max) throws ListLengthException {
        int length = list.size();
        if(length < min || length > max){
            throw new ListLengthException("친구 배열 범위 초과! 최소: " +min +" 최대: "+max);
        }
    }
}
