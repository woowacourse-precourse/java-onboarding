package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

class FriendInfoController {
    static final int MAX_RECOMMEND_SIZE = 5;
    static final int SAME_FRIEND_POINT = 10;
    static final int VISITOR_POINT = 1;

    private static int getUsersFriendIndex(String user, List<String> friendsRelation) {
        if (friendsRelation.get(0).equals(user)) {
            return 1;
        }
        if (friendsRelation.get(1).equals(user)) {
            return 0;
        }
        return -1;
    }
}