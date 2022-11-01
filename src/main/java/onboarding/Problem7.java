package onboarding;

import onboarding.problem7.SNSController;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        SNSController snsController = new SNSController();

        for(List<String> friend : friends){
            snsController.addFriend(friend.get(0), friend.get(1));
        }
        snsController.addVisitors(user, visitors);

        List<String> answer = snsController.findRecommendUser(user);
        return answer;
    }
}
