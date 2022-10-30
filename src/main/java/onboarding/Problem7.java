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

        if(visitors.size() > 10_000) {
            throw new Exception("visitors의 길이는 0이상 10_000 이하여야 합니다");
        }
//        List<User> usersRecommended = new UserScore(target.getName(), visitors);

        return answer;
    }
}
