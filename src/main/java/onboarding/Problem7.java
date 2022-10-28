package onboarding;

import onboarding.problem7.domain.Users;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Users users = new Users(user, friends, visitors);
        
        users.addAllUserFriends(friends);
        users.addScoreOfNumberOfFriendsYouKnowTogether(user);
        users.addScoreOfVisit(visitors);
    
        return users.recommendedFriends(user);
    }
}
