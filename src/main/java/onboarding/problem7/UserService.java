package onboarding.problem7;


import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;

    public UserService(UserRepository userRepository, FriendRepository friendRepository) {
        this.userRepository = userRepository;
        this.friendRepository = friendRepository;
    }

    public void saveAll(String username, List<List<String>> friends, List<String> visitors) {
        List<List<String>> users = new ArrayList<>(friends);
        users.add(visitors);
        users.add(List.of(username));

        users.stream()
                .flatMap(Collection::stream)
                .forEach(i -> userRepository.save(i, new User(i)));
    }

    public Map<String, User> findAll() {
        return userRepository.findAll();
    }

    public void addFriends(List<List<String>> friends) {
        for (List<String> friend : friends) {
            User firstUser = userRepository.findByUsername(friend.get(0));
            User secondUser = userRepository.findByUsername(friend.get(1));

            saveAllFriends(firstUser, secondUser);
        }

    }

    private void saveAllFriends(User firstUser, User secondUser) {
        if (friendRepository.isNotSavedUser(firstUser)) {
            friendRepository.save(firstUser, new Friends(secondUser));
        }
        friendRepository.findByUser(firstUser).add(secondUser);

        if (friendRepository.isNotSavedUser(secondUser)) {
            friendRepository.save(secondUser, new Friends(firstUser));
        }
        friendRepository.findByUser(secondUser).add(firstUser);
    }



}
