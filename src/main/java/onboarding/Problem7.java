package onboarding;

import model.FriendAlgorithms;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        FriendAlgorithms friendAlgorithms = new FriendAlgorithms(user, friends, visitors);
        return friendAlgorithms.friendRecommend();
    }
}
