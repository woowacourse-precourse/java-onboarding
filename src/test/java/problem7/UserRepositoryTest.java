package problem7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest {

    @Test
    void 유저이름으로_해당유저를_찾는기능() {
        User user = new User("donut");
        UserRepository userRepository = new UserRepository();

        userRepository.save("donut", user);
        User findUser = userRepository.findByUserid("donut");

        assertThat(findUser).isEqualTo(user);
    }
}
