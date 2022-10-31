package onboarding;

import onboarding.problem6.User;
import onboarding.problem6.UserList;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        UserList userList = new UserList();

        for (List<String> userInfo : forms) {
            userList.addUser(new User(userInfo));
        }

        return userList.generateWarningList();
    }
}
