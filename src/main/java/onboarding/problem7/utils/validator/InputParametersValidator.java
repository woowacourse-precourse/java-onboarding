package onboarding.problem7.utils.validator;

import onboarding.problem7.utils.Constants;
import onboarding.problem7.utils.validator.exception.InputParametersException;

import java.util.List;

public class InputParametersValidator{
    public InputParametersValidator(String user, List<List<String>> friend, List<String> visitor) throws InputParametersException{
        try{
            new UserLengthValidator(user, friend, visitor);
            new FriendRelationLengthValidator(friend);
            new FriendListValidator(friend, Constants.MIN_FRIEND_LIST_LENGTH, Constants.MAX_FRIEND_LIST_LENGTH);
            new ListLengthValidator(visitor, Constants.MIN_VISITOR_LIST_LENGTH, Constants.MAX_VISITOR_LIST_LENGTH);
            new NotLowerCaseValidator(user, friend, visitor);
        }catch (Exception e){
            throw new InputParametersException("유효하지 않은 파라미터");
        }
    }
}
