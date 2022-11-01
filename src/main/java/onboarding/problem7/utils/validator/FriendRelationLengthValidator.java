package onboarding.problem7.utils.validator;

import onboarding.problem7.utils.Constants;
import onboarding.problem7.utils.validator.exception.FriendRelationLengthException;

import java.util.List;

public class FriendRelationLengthValidator {
    private List<List<String>> friend;
    public FriendRelationLengthValidator(List<List<String>> friend) throws FriendRelationLengthException{
        this.friend = friend;
        validateAllFriendRelationLength();
    }

    private void validateAllFriendRelationLength() throws FriendRelationLengthException{
        for(List<String> reladtion : friend){
            validateFriendRelationLength(reladtion);
        }
    }

    private void validateFriendRelationLength(List<String> reladtion) throws FriendRelationLengthException{
        if(reladtion.size() != Constants.FRIEND_RELATION){
            throw new FriendRelationLengthException("친구 관계 원소 리스트의 길이가 맞지 않음");
        }
    }
}
