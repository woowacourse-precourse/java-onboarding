package onboarding.problem7;

import java.util.List;

public interface Recommendator {

    List<String> recommend(List<String> friendsOfFriends, List<String> friendsOfRecords, int friendOfFriendPoint, int visitedFriendPoint, int recommendationFriendsLimit);
}
