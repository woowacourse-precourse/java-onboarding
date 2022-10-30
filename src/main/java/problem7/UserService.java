package problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserService {

    public static final int USER_ID_INDEX = 0;
    public static final int OTHER_USER_ID_INDEX = 1;
    public static final int INIT_SCORE = 0;
    public static final int VISITOR_DEFAULT_SCORE = 0;
    public static final int VISITOR_SCORE = 1;
    public static final int COMMON_FRIEND_SCORE = 10;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addFriend(List<String> friend) {
        String userId = friend.get(USER_ID_INDEX);
        String otherUserid = friend.get(OTHER_USER_ID_INDEX);

        User findUser = findUser(userId);
        User findOtherUser = findUser(otherUserid);

        findUser.addFriend(findOtherUser);
        findOtherUser.addFriend(findUser);
    }

    private User findUser(String userId) {
        return userRepository.findByUserid(userId).orElse(createUser(userId));
    }

    private User createUser(String userId) {
        User createUser = new User(userId);
        userRepository.save(userId, createUser);
        return createUser;
    }

    public boolean isFriend(String userId, String otherUserid) {
        User findUser = userRepository.findByUserid(userId).orElseThrow();
        User findOtherUser = userRepository.findByUserid(otherUserid).orElseThrow();

        return findUser.isFriend(findOtherUser) && findOtherUser.isFriend(findUser);
    }

    public void addFriends(List<List<String>> friends) {
        friends.forEach(this::addFriend);
    }

    public List<String> operateFriendCommendation(String userId) {
        return createCandidateUserIds(userId);
    }

    private List<String> createCandidateUserIds(String userId) {
        List<String> userIds = createAllUserIds(userId);
        User user = userRepository.findByUserid(userId).orElseThrow();
        user.deleteFriendIds(userIds);
        return userIds;
    }

    public List<String> createAllUserIds(String exclusiveUserId) {
        return userRepository.findAllUserIdsExclusiveTo(exclusiveUserId);
    }

    public List<FriendCommendResponseDto> operateFriendCommendation(String userId, List<String> visitors) {
        Map<String, Integer> commendFriend = new HashMap<>();

        List<String> candidateUserIds = operateFriendCommendation(userId);
        candidateUserIds.forEach(s -> commendFriend.put(s, INIT_SCORE));

        User user = userRepository.findByUserid(userId).orElseThrow();
        scoreVisitors(visitors, commendFriend, user);
        scoreCommonFriend(commendFriend, user);

        return createResponseDtos(commendFriend);
    }

    private void scoreVisitors(List<String> visitors, Map<String, Integer> commendFriend, User user) {
        visitors.stream().filter(user::isNotFriend)
                .forEach(visitorId -> commendFriend.put(visitorId,
                        commendFriend.getOrDefault(visitorId, VISITOR_DEFAULT_SCORE) + VISITOR_SCORE));
    }

    private void scoreCommonFriend(Map<String, Integer> commendFriend, User user) {
        for (String commendId : commendFriend.keySet()) {
            userRepository.findByUserid(commendId).ifPresent(commendUser -> {
                int count = user.commonFriendCount(commendUser);
                commendFriend.put(commendId, (commendFriend.get(commendId) + (COMMON_FRIEND_SCORE * count)));
            });
        }
    }

    private List<FriendCommendResponseDto> createResponseDtos(Map<String, Integer> commendFriend) {
        return commendFriend.keySet().stream()
                .map(id -> new FriendCommendResponseDto(id, commendFriend.get(id)))
                .collect(Collectors.toList());
    }
}