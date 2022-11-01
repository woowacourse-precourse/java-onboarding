package onboarding.problem7.utils.validator;

import onboarding.problem7.utils.Constants;
import onboarding.problem7.utils.validator.exception.NotLowerCaseException;

import java.util.List;
import java.util.regex.Pattern;

public class NotLowerCaseValidator {
    private String user;
    private List<List<String>> friend;
    private List<String> visitor;

    public NotLowerCaseValidator(String user, List<List<String>> friend, List<String> visitor) throws NotLowerCaseException {
        this.user = user;
        this.friend = friend;
        this.visitor = visitor;

        validateUser(user);
        validateAllFriend();
        validateVisitor();
    }

    private void validateVisitor() throws NotLowerCaseException {
        for(String name: this.visitor){
            validateUser(name);
        }
    }

    private void validateAllFriend() throws NotLowerCaseException {
        for(List<String> relation: friend){
            validateFriend(relation);
        }
    }

    private void validateFriend(List<String> relation) throws NotLowerCaseException {
        validateUser(relation.get(0));
        validateUser(relation.get(1));
    }

    private void validateUser(String user) throws NotLowerCaseException {
        if(!Pattern.matches(Constants.LOWER_REGEX, user)){
            throw new NotLowerCaseException("소문자가 아닌 유저가 있음");
        }
    }
}
