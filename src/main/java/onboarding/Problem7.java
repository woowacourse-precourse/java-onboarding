package onboarding;

import onboarding.problem7.User;
import onboarding.problem7.UserRelation;
import onboarding.problem7.UserStore;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) throws Exception {
        List<String> answer = Collections.emptyList();
        User target = new User(user);
        UserStore.add(target);
        UserRelation.addBulk(friends);

        return answer;
    }
}
