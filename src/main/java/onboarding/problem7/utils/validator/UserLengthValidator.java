package onboarding.problem7.utils.validator;

import onboarding.problem7.utils.Constants;
import onboarding.problem7.utils.validator.exception.UserLengthException;

import java.util.List;

public class UserLengthValidator {
    private String user;
    private List<List<String>> friend;
    private List<String> visitor;

    public UserLengthValidator(String user, List<List<String>> friend, List<String> visitor) throws UserLengthException{
        this.user = user;
        this.friend = friend;
        this.visitor = visitor;

        validateUser(user);
        validateAllFriend();
        validateVisitor();
    }

    private void validateVisitor() throws UserLengthException{
        for(String name: this.visitor){
            validateUser(name);
        }
    }

    private void validateAllFriend() throws UserLengthException{
        for(List<String> relation: friend){
            validateFriend(relation);
        }
    }

    private void validateFriend(List<String> relation) throws UserLengthException{
        validateUser(relation.get(0));
        validateUser(relation.get(1));
    }

    private void validateUser(String user) throws UserLengthException{
        int length = user.length();
        if(length < Constants.MIN_USER_LENGTH || length > Constants.MAX_USER_LENGTH){
            throw new UserLengthException("최대 이름 길이 초과 유저가 있음");
        }
    }
}
