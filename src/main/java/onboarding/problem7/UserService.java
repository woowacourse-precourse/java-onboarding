package onboarding.problem7;


import java.util.*;

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
                .forEach(user -> userRepository.save(user, new User(user)));
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

    public List<User> findNearByFriends(String username) {
        List<User> nearByFriends = new ArrayList<>();

        User user = userRepository.findByUsername(username);
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
