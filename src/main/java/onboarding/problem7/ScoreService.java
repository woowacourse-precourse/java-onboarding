package onboarding.problem7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreService {
    private static final int NEARBY_FRIEND_SCORE = 10;
    private static final int VISITOR_SCORE = 1;

    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    private final VisitorRepository visitorRepository;

    public ScoreService(UserRepository userRepository, FriendRepository friendRepository, VisitorRepository visitorRepository) {
        this.userRepository = userRepository;
        this.friendRepository = friendRepository;
        this.visitorRepository = visitorRepository;
    }

    public List<User> getRecommendList(String username) {
        calculateScore(username);
        return userRepository.findAll().values()
                .stream()
                .filter(User::isNotZeroScore)
                .sorted(Comparator.comparing(User::getScore).reversed()
                        .thenComparing(User::getName))
                .collect(Collectors.toList());
    }

    private void calculateScore(String username) {
        User user = userRepository.findByUsername(username);
        List<User> nearByFriends = findNearByFriends(user);
        List<User> visitorList = findVisitorList(user);
        Friends userFriend = friendRepository.findByUser(user);

        addNearByFriendsScore(nearByFriends, userFriend);
        addVisitorsScore(visitorList, userFriend);
    }

    private void addNearByFriendsScore(List<User> nearByFriends, Friends userFriend) {
        for (User nearByFriend : nearByFriends) {
            if (userFriend.isNotFriend(nearByFriend)) {
                nearByFriend.addScore(NEARBY_FRIEND_SCORE);
            }
        }
    }

    private void addVisitorsScore(List<User> visitorList, Friends userFriend) {
        for (User visitor : visitorList) {
            if (userFriend.isNotFriend(visitor)) {
                visitor.addScore(VISITOR_SCORE);
            }
        }
    }


    private List<User> findVisitorList(User user) {
        Visitor byUser = visitorRepository.findByUser(user);
        return byUser.toList();
    }

    private List<User> findNearByFriends(User user) {
        List<User> nearByFriends = new ArrayList<>();

        Friends friends = friendRepository.findByUser(user);

        List<User> myFriendList = friends.toList();

        for (User friend : myFriendList) {
            Friends nearFriend = friendRepository.findByUser(friend);
            nearByFriends.addAll(nearFriend.toList());
            nearByFriends.remove(user);
        }

        return nearByFriends;
    }
}
