package onboarding.problem7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserRepositoryTest {
    private UserRepository userRepository;

    @Test
    void 중복된_사용자를_추가하더라도_등록되지_않습니다() {
        this.userRepository = new UserRepository("user", List.of(
                List.of("user1", "user1"),
                List.of("user1", "user2"),
                List.of("user1", "user3")

        ), List.of("user3"));
        assertThat(userRepository.findAll()).hasSize(4);
    }

    @Test
    void 사용자_이름으로_데이터를_조회_할_수_있습니다() {
        this.generateUserData();
        assertThat(userRepository.findByName("user")
                                 .name()).isEqualTo("user");
    }

    @Test
    void 친구로_등록한_경우_해당_사용자의_친구의_친구들은_10점을_가지고_있습니다() {
        this.generateUserData();
        var user = userRepository.findByName("user");

        var friends = user.friends()
                          .values();
        friends.forEach(friend -> {
            friend.friends()
                  .values()
                  .forEach(friendAFriend -> {
                      if(friendAFriend == user) {
                          return;
                      }
                      assertThat(friendAFriend.score()).isEqualTo(10);
                  });
        });


    }

    private void generateUserData() {
        this.userRepository = new UserRepository("user", List.of(
                List.of("user", "user1"),
                List.of("user1", "user2"),
                List.of("user1", "user3")

        ), List.of("user4"));
    }

    @BeforeEach
    private void tearDown() {
        this.userRepository = null;
    }
}