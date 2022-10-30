package problem7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
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

        UserService userService = new UserService(userRepository);
        userService.addFriend(friend);
        boolean result = userService.isFriend("donut", "andole");

        assertThat(result).isTrue();
    }
}
