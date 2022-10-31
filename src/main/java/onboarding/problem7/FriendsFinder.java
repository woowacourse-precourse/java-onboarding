package onboarding.problem7;

import static onboarding.problem7.Friend.FIRST_FRIEND;
import static onboarding.problem7.Friend.SECOND_FRIEND;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class FriendsFinder implements Finder {

    @Override
    public List<String> findNewFriendsFromUserFriends(String user, List<List<String>> friends) {
        List<String> userNewFriends = new ArrayList<>();

        for(String userCurrentFriend : findUserCurrentFriends(user, friends)) {
            findFriendsOfUserFriends(user, userCurrentFriend, friends, userNewFriends);
        }

        return userNewFriends;
    }

    @Override
    public List<String> findNewFriendsFromVisitRecord(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> userNewFriends = new ArrayList<>();
        visitors.stream()
            .filter(isVisitor(user, findUserCurrentFriends(user,friends)))
            .forEach(userNewFriends::add);

        return userNewFriends;
    }

    private Predicate<String> isVisitor(String user, List<String> userCurrentFriends) {
        return visitor -> !userCurrentFriends.contains(visitor) && !visitor.equals(user);
    }

    private List<String> findUserCurrentFriends(String user, List<List<String>> friends) {
        List<String> userCurrentFriends = new ArrayList<>();
        findFriendOfFriend(user, friends, userCurrentFriends);
        return userCurrentFriends;
    }

    private void findFriendOfFriend(String user, List<List<String>> friends,
        List<String> userCurrentFriends) {
        for (List<String> friendPair : friends) {
            if(isFriend(friendPair, user, userCurrentFriends, FIRST_FRIEND, SECOND_FRIEND)) {
                userCurrentFriends.add(friendPair.get(SECOND_FRIEND.value()));
                continue;
            }

            if(isFriend(friendPair, user, userCurrentFriends, SECOND_FRIEND, FIRST_FRIEND)) {
                userCurrentFriends.add(friendPair.get(FIRST_FRIEND.value()));
            }
        }
    }

    private boolean isFriend(List<String> friendPair, String user,
        List<String> userCurrentFriends, Friend friend1, Friend friend2) {
        return friendPair.get(friend1.value()).equals(user) && !userCurrentFriends.contains(friendPair.get(friend2.value()));
    }

    private void findFriendsOfUserFriends(String user, String userCurrentFriend, List<List<String>> friends,
        List<String> userNewFriends) {
        friends.stream()
            .filter(isFriendsOfFriends(user, userCurrentFriend))
            .flatMap(Collection::stream)
            .filter(isNotCurrentFriend(userCurrentFriend))
            .forEach(userNewFriends::add);
    }

    private Predicate<List<String>> isFriendsOfFriends(String user, String userCurrentFriend) {
        return friendPair -> friendPair.contains(userCurrentFriend) && !friendPair.contains(user);
    }

    private Predicate<String> isNotCurrentFriend(String userCurrentFriend) {
        return friend -> !friend.equals(userCurrentFriend);
    }
}
