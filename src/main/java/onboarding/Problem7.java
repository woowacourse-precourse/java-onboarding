package onboarding;

import onboarding.problem7.UserManager;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        UserManager um = new UserManager(friends, visitors);
        return um.recommandTo(user);
    }
}
