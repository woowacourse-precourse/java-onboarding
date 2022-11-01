package onboarding;

import onboarding.problem7.collections.CollectionMaker;
import onboarding.problem7.collections.FriendList;
import onboarding.problem7.collections.VisitorList;
import onboarding.problem7.friendandscore.FriendAndScore;
import onboarding.problem7.wrapper.User;
import onboarding.problem7.wrapper.UserAndScore;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User targetUser = new User(user);
        CollectionMaker collectionMaker = new CollectionMaker(friends, visitors);
        FriendList friendList = collectionMaker.getFriendList();
        VisitorList visitorList = collectionMaker.getVisitorList();
        FriendAndScore friendAndScore = new FriendAndScore(friendList, visitorList);

        List<User> visitorsOfNotFriendOfUser = friendAndScore.getVisitorsNotFriendOf(targetUser);
        List<User> friendsOfUserFriends = friendAndScore.getFriendsOfUserFriend(targetUser);

        List<UserAndScore> newFriendAndScoreList = friendAndScore.getNewFriendAndScoreListByFriendsOfFriendAndVisitors(friendsOfUserFriends, visitorsOfNotFriendOfUser);
        return friendAndScore.getRecommendationList(newFriendAndScoreList);
    }
}
