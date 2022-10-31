package onboarding.problem7;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    public static boolean check(String user, List<List<String>> friends, List<String> visitors) {
        if (userValidation(user) && friendValidation(friends) && visitorValidation(visitors)) {
            return true;
        }
        return false;
    }
    public static boolean userValidation(String user) {
        if (user.length() < Constant.USER_LENGTH_MIN || user.length() > Constant.USER_LENGTH_MAX) {
            return false;
        } else if (!Pattern.matches(Constant.USER_REGEX, user)) {
            return false;
        }
        return true;
    }
    public static boolean friendValidation(List<List<String>> friends) {
        if (friends.size() < Constant.FRIEND_LENGTH_MIN || friends.size() > Constant.FRIEND_LENGTH_MAX) {
            return false;
        }
        for (List<String> relation : friends) {
            if (relation.size() != 2) {
                return false;
            } else if(relation.stream().anyMatch(id -> id.length() < Constant.ID_LENGTH_MIN
                    || id.length() > Constant.ID_LENGTH_MAX)) {
                return false;
            }
        }
        return true;
    }

    public static boolean visitorValidation(List<String> visitors) {
        if (visitors.size() > Constant.VISITOR_LENGTH_MAX) {
            return false;
        }
        return true;
    }
}


