package onboarding;

import onboarding.problem7.domain.Users;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Users users = new Users(friends, visitors);
        
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addVisitScore(visitors);
    
        return users.recommendedFriends(user);
    }
}
