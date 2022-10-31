package onboarding.problem7;


import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    private final VisitorRepository visitorRepository;

    public UserService(UserRepository userRepository, FriendRepository friendRepository, VisitorRepository visitorRepository) {
        this.userRepository = userRepository;
        this.friendRepository = friendRepository;
        this.visitorRepository = visitorRepository;
    }

    public void saveAll(String username, List<List<String>> friends, List<String> visitors) {
        List<List<String>> users = new ArrayList<>(friends);
        users.add(visitors);
        users.add(List.of(username));

        users.stream()
                .flatMap(Collection::stream)
                .forEach(user -> userRepository.save(user, new User(user)));
    }

    public Map<String, User> findAll() {
        return userRepository.findAll();
    }

    public void saveFriends(List<List<String>> friends) {
        for (List<String> friend : friends) {
            User firstUser = userRepository.findByUsername(friend.get(0));
            User secondUser = userRepository.findByUsername(friend.get(1));

            saveAllFriendRelation(firstUser, secondUser);
        }

    }

    private void saveAllFriendRelation(User firstUser, User secondUser) {
        if (friendRepository.isNotSavedUser(firstUser)) {
            friendRepository.save(firstUser, new Friends(secondUser));
        }
        Friends firstUserFriend = friendRepository.findByUser(firstUser);
        firstUserFriend.add(secondUser);

        if (friendRepository.isNotSavedUser(secondUser)) {
            friendRepository.save(secondUser, new Friends(firstUser));
        }
        Friends secondUserFriend = friendRepository.findByUser(secondUser);
        secondUserFriend.add(firstUser);
    }

    public void saveVisitor(String username, List<String> visitors) {
        User user = userRepository.findByUsername(username);
        List<User> visitor = visitors.stream()
                .map(userRepository::findByUsername)
                .collect(Collectors.toList());

        visitorRepository.save(user, new Visitor(visitor));
    }

}
