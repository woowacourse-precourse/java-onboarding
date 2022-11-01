package onboarding.problem7.friendandscore;

import onboarding.problem7.collections.FriendList;
import onboarding.problem7.collections.VisitorList;
import onboarding.problem7.wrapper.User;
import onboarding.problem7.wrapper.UserAndScore;

import java.util.*;

public class FriendAndScore {

    private final FriendList friendList;
    private final VisitorList visitorList;
    private final int FRIENDS_OF_FRIEND_POINT;
    private final int VISITORS_POINT;

    public FriendAndScore(FriendList friendList, VisitorList visitors) {
        this.friendList = friendList;
        this.visitorList = visitors;
        this.FRIENDS_OF_FRIEND_POINT = 10;
        this.VISITORS_POINT = 1;
    }

    public List<User> getFriendsOfUserFriend(User user) {
        List<User> friendsOfUser = friendList.getFriendListOf(user);
        return friendList.getFriendsOfFriendBy(user, friendsOfUser);
    }

    public List<User> getVisitorsNotFriendOf(User user) {
        List<User> friendsOfUser = friendList.getFriendListOf(user);
        return visitorList.getVisitorListExcluding(friendsOfUser);
    }

    public List<User> addTwoListsWithoutDuplicate(List<User> friendsOfUserFriends, List<User> visitorsOfNotFriendOfUser) {
        Set<User> set = new HashSet<>();
        set.addAll(friendsOfUserFriends);
        set.addAll(visitorsOfNotFriendOfUser);
        return List.copyOf(set);
    }

    public Map<User, Integer> mapNewFriendAndScore(List<User> friendsOfUserFriends, List<User> visitorsOfNotFriendOfUser) {
        List<User> newFriend = addTwoListsWithoutDuplicate(friendsOfUserFriends, visitorsOfNotFriendOfUser);
        FriendAndScoreMapper newFriendAndScoreMapper = new FriendAndScoreMapper(newFriend);
        newFriendAndScoreMapper.calculateScoreOfNewFriendWith(friendsOfUserFriends, FRIENDS_OF_FRIEND_POINT);
        newFriendAndScoreMapper.calculateScoreOfNewFriendWith(visitorsOfNotFriendOfUser, VISITORS_POINT);
        return newFriendAndScoreMapper.getFriendAndScore();
    }

    public List<UserAndScore> transformMapIntoList(Map<User, Integer> newFriendAndScore) {
        List<UserAndScore> newFriendAndScoreList = new ArrayList<>();
        for (Map.Entry<User, Integer> entry : newFriendAndScore.entrySet()) {
            newFriendAndScoreList.add(new UserAndScore(entry.getKey(), entry.getValue()));
        }
        return newFriendAndScoreList;
    }

    public List<UserAndScore> getNewFriendAndScoreListByFriendsOfFriendAndVisitors(List<User> friendsOfUserFriends, List<User> visitorsOfNotFriendOfUser) {
        Map<User, Integer> newFriendAndScoreMap = mapNewFriendAndScore(friendsOfUserFriends, visitorsOfNotFriendOfUser);
        return transformMapIntoList(newFriendAndScoreMap);
    }

    public List<UserAndScore> sortListByScoreAndUserId(List<UserAndScore> newFriendAndScoreList) {
        newFriendAndScoreList.sort(Comparator.comparing(UserAndScore::getScore)
                .reversed()
                .thenComparing(UserAndScore::getUser));
        return newFriendAndScoreList;
    }
}
