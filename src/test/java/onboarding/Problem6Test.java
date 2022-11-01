package onboarding;

import onboarding.problem6.User;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6Test {

    @Nested
    class Problem6UnitTest{
        @Test
        void case1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<List<String>> forms = List.of(
                    List.of("kim@email.com", "김ㅡ이"),
                    List.of("nam@email.com", "ㅡ이야"),
                    List.of("choi@email.com", "최강"),
                    List.of("lee@email.com", "강합니다"),
                    List.of("jun@email.com", "왜ㅇㅡ이야")
            );
            List<String> result = List.of("jun@email.com", "kim@email.com", "nam@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    }

    @Nested
    class UserRepositoryTest{

        private SnsRepository repository=UserRepository.of();

        @AfterEach
        void after(){
            repository.removeAll();
        }

        @Test
        void testSave(){
            User user = new User("jm@email.com", "제이엠");
            User saveUser = (User) repository.save(user);
            Optional<Domain> findUser=repository.findById(saveUser.getId());
            findUser.orElseThrow(()->new RuntimeException());
            assertThat(saveUser).isEqualTo(findUser.get());
        }

        @Test
        void testSearch(){
            User user = new User("jm@email.com", "제엠");
            User save = (User)repository.save(user);
            Optional<Domain> findUser=repository.findById(save.getId());
            findUser.orElseThrow(()->new RuntimeException());
            assertThat(save).isEqualTo((User)findUser.get());
        }

        @Test
        void testSearchFail(){
            User user = new User("jm@email.com", "제엠");
            User save = (User)repository.save(user);
            Optional<Domain> findUser=repository.findById(save.getId()+20);
            assertThat(Optional.empty()).isEqualTo(findUser);
        }

        @Test
        void testUpdate(){
            User user = new User("jm@email.com", "제엠");
            User save = (User)repository.save(user);
            save.setNickName("제이");
            User updateUser=(User) repository.update(save);
            assertThat(save).isEqualTo(updateUser);
        }
    }

}
