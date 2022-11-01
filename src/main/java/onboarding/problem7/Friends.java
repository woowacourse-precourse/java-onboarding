package onboarding.problem7;

import onboarding.problem7.exception.FriendsException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Friends {
    private static final int MAX = 10_000;
    private final List<Friend> friends;

    public Friends(List<List<String>> friends) {
        checkFriends(friends);
        this.friends = convertFriendsId(friends);
    }

    private static List<Friend> convertFriendsId(List<List<String>> friends) {
        return friends.stream()
                .map(Friends::convertSnsIds)
                .map(Friend::new)
                .collect(Collectors.toList());
    }

    private static List<SnsId> convertSnsIds(List<String> friend) {
        return friend.stream().map(SnsId::new)
                .collect(Collectors.toList());
    }

    private static void checkFriends(List<List<String>> friends) {
        checkMin(friends);
        checkMAX(friends);
    }

    private static void checkMAX(List<List<String>> friends) {
        if (friends.size() > MAX) {
            throw new FriendsException("처리할 수 있는 친구 정보보다 더 많습니다.");
        }
    }

    private static void checkMin(List<List<String>> friends) {
        if (friends.isEmpty()) {
            throw new FriendsException("친구 관계 정보가 없습니다.");
        }
    }

    public List<SnsId> findAcquaintance(SnsId user) {
        List<SnsId> acquaintance = removeUser(user);
        acquaintance.removeAll(findFriend(user));
        return acquaintance;
    }

    private List<SnsId> findFriend(SnsId user) {

        return friends.stream()
                .map(Friend::getFriend)
                .filter(friend -> friend.contains(user))
                .flatMap(Collection::stream)
                .filter(fr -> !fr.equals(user))
                .collect(Collectors.toList());
    }

    private List<SnsId> removeUser(SnsId user) {
        return friends.stream()
                .map(Friend::getFriend)
                .filter(friend -> !friend.contains(user))
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }


}
