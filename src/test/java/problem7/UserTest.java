package problem7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userService = new UserService(userRepository);
    }

    @Test
    void 유저이름으로_해당유저를_찾는기능() {
        User user = new User("donut");

        userRepository.save("donut", user);
        User findUser = userRepository.findByUserid("donut").get();

        assertThat(findUser).isEqualTo(user);
    }

    @Test
    void 하나의_친구관계가_주어질때_각유저에_친구관계적용() {
        List<String> friend = List.of("donut", "andole");

        userService.addFriend(friend);
        boolean result = userService.isFriend("donut", "andole");

        assertThat(result).isTrue();
    }

    @Test
    void 여러개의_친구관계가_주어질때_각각의유저에_친구관계적용() {
        userService.addFriends(createFriends());

        assertThat(userService.isFriend("mrko", "donut")).isTrue();
        assertThat(userService.isFriend("mrko", "shakevan")).isTrue();
        assertThat(userService.isFriend("donut", "mrko")).isTrue();
        assertThat(userService.isFriend("shakevan", "mrko")).isTrue();
    }

    private List<List<String>> createFriends() {
        List<List<String>> friends = new ArrayList<>();
        friends.add(List.of("donut", "andole"));
        friends.add(List.of("donut", "jun"));
        friends.add(List.of("donut", "mrko"));
        friends.add(List.of("shakevan", "andole"));
        friends.add(List.of("shakevan", "jun"));
        friends.add(List.of("shakevan", "mrko"));

        return friends;
    }

    @Test
    void 디폴트_친구추천리스트_만들기() {
        userService.addFriends(createFriends());
        List<String> result = userService.operateFriendRecommendation("mrko");
        assertThat(result).contains("donut", "andole", "jun", "shakevan");
    }
}
