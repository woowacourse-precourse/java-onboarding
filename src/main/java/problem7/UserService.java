package problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    public static final int USER_ID_INDEX = 0;
    public static final int OTHER_USER_ID_INDEX = 1;
    public static final int INIT_SCORE = 0;
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

    public List<String> createAllUserIds(String exclusiveUserId) {
        return userRepository.findAllUserIdsExclusiveTo(exclusiveUserId);
    }

    public List<String> operateFriendCommendation(String userId) {
        Map<String, Integer> commendFriend = new HashMap<>();

        List<String> candidateUserIds = createCandidateUserIds(userId);
        candidateUserIds.forEach(s -> commendFriend.put(s, INIT_SCORE));

        return new ArrayList<>(commendFriend.keySet());
    }

    private List<String> createCandidateUserIds(String userId) {
        List<String> userIds = createAllUserIds(userId);
        User user = userRepository.findByUserid(userId).orElseThrow();
        user.deleteFriendIds(userIds);
        return userIds;
    }
}