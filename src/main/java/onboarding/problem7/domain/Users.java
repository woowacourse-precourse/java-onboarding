package onboarding.problem7.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Users {
    private final Map<String, User> users;
    
    public Users(final List<List<String>> friends, final List<String> visitors) {
        this.users = initUsers(friends, visitors);
    }
    
    private Map<String, User> initUsers(List<List<String>> friends, final List<String> visitors) {
        List<List<String>> mergeFriends = mergeUsers(friends, visitors);
        return mergeFriends.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(friendName -> friendName, User::new, (firstUser, secondUser) -> firstUser));
    }
    
    private List<List<String>> mergeUsers(final List<List<String>> friends, final List<String> visitors) {
        List<List<String>> tmpFriends = new ArrayList<>(friends);
        tmpFriends.add(visitors);
        return tmpFriends;
    }
    
    public void addAllUserFriends(final List<List<String>> friends) {
        for (List<String> friend : friends) {
            final String firstUserName = friend.get(0);
            final String secondUserName = friend.get(1);
            
            users.get(firstUserName).addFriend(secondUserName);
            users.get(secondUserName).addFriend(firstUserName);
        }
    }
    
    public void addScoreOfNumberOfFriendsYouKnowTogether(final String userName) {
        for (String targetName : users.keySet()) {
            addScoreOfNumberOfFriendsYouKnowTogether(userName, users.get(userName), targetName);
        }
    }
    
    private void addScoreOfNumberOfFriendsYouKnowTogether(final String userName, final User user, final String targetName) {
        if (!userName.equals(targetName)) {
            final User target = users.get(targetName);
            final int numberOfFriendsYouKnowTogether = target.numberOfFriendsYouKnowTogether(user);
            target.addScoreOfNumberOfFriendsYouKnowTogether(numberOfFriendsYouKnowTogether);
        }
    }
    
    public void addVisitScore(final List<String> visitors) {
        visitors.stream()
                .map(users::get)
                .forEach(User::addVisitScore);
    }
    
    public List<String> recommendedFriends(String user) {
        final Set<String> friends = users.get(user).getFriends();
        return users.keySet().stream()
                .filter(userName -> !friends.contains(userName))
                .map(users::get)
                .filter(User::isNotZeroScore)
                .sorted()
                .limit(5)
                .map(User::getUserName)
                .collect(Collectors.toList());
    }
    
    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
