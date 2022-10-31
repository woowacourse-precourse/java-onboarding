package onboarding;

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
                    List.of("onepiece@email.com", "원피수"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("onepisu@email.com", "원피수"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("suonepi@email.com", "수원피")
            );

            List<String> result = List.of();
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        void case3() {
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
    static class UserRepositoryTest{

        private static SnsRepository repository=RepositoryFactory.makeRepository();
        private static User beforeUser;

        @BeforeEach
        void before(){
            User user = new User("jm@email.com", "제엠");
            beforeUser = repository.save(user);
        }

        @AfterEach
        void after(){
            repository.removeAll();
        }

        @Test
        void 저장(){
            User user = new User("jm@email.com", "제이엠");
            User saveUser = repository.save(user);
            Optional<User> findUser=repository.findById(1);
            findUser.orElseThrow(()->new RuntimeException());
            assertThat(saveUser).isEqualTo(findUser.get());
        }

        @Test
        void 검색(){
            Optional<User> findUser=repository.findById(0);
            findUser.orElseThrow(()->new RuntimeException());
            assertThat(beforeUser).isEqualTo(findUser.get());
        }

        @Test
        void 검색실패(){
            Optional<User> findUser=repository.findById(1);
            assertThat(Optional.empty()).isEqualTo(findUser);
        }

        @Test
        void 업데이트(){
            beforeUser.setNickName("제이");
            User updateUser=repository.update(beforeUser);
            assertThat(beforeUser).isEqualTo(updateUser);
        }
    }

    @Nested
    class UserServiceTest{

    }
}
