package onboarding;

import onboarding.problem7.*;
import org.junit.jupiter.api.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7Test {

    @Nested
    class Problem7UnitTest{
        @Test
        void case1() {
            String user = "andole";
            List<List<String>> friends = List.of(
                    List.of("andole", "jun"),
                    List.of("donut", "jun"),
                    List.of("donut", "shakevan"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "bedi"),
                    List.of("anne", "jun")
            );
            List<String> visitors = List.of("donut", "mrko", "peter", "sam");
            List<String> result = List.of("donut", "anne", "bedi", "mrko", "peter");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

    }
    @Test
    void case2() {
        String user = "andole";
        List<List<String>> friends = List.of(
                List.of("andole", "jun"),
                List.of("andole", "bedi"),
                List.of("jun", "shakevan"),
                List.of("jun", "kane"),
                List.of("jun", "sam"),
                List.of("bedi", "shakevan"),
                List.of("bedi", "anne"),
                List.of("bedi", "sam"),
                List.of("anne", "mrko")
        );
        List<String> visitors = List.of("donut", "anne", "mrko", "mrko", "sam");
        List<String> result = List.of("sam", "shakevan", "anne", "kane", "mrko");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case3() {
        String user = "hello";
        List<List<String>> friends = List.of(
                List.of("andole", "jun"),
                List.of("andole", "bedi"),
                List.of("jun", "shakevan"),
                List.of("jun", "kane"),
                List.of("jun", "sam"),
                List.of("bedi", "shakevan"),
                List.of("bedi", "anne"),
                List.of("bedi", "sam"),
                List.of("anne", "mrko")
        );
        List<String> visitors = List.of("donut", "anne", "mrko", "mrko", "sam");
        List<String> result = List.of("mrko", "anne", "donut", "sam");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case4() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Nested
    static class UserRepositoryTest{

        private static SnsRepository repository= RepositoryFactory.makeSnsRepository();
        private static Domain beforeUser;

        @BeforeEach
        void before(){
            User user = new User("제엠");
            beforeUser = repository.save(user);
        }

        @AfterEach
        void after(){
            repository.removeAll();
        }

        @Test
        void 저장(){
            User user = new User("mrko");
            Domain saveUser = repository.save(user);
            Optional<Domain> findUser=repository.findById(1);
            findUser.orElseThrow(()->new RuntimeException());
            assertThat(saveUser).isEqualTo(findUser.get());
        }

        @Test
        void 검색(){
            Optional<Domain> findUser=repository.findById(0);
            findUser.orElseThrow(()->new RuntimeException());
            assertThat(beforeUser).isEqualTo(findUser.get());
        }

        @Test
        void 검색실패(){
            Optional<Domain> findUser=repository.findById(1);
            assertThat(Optional.empty()).isEqualTo(findUser);
        }

        @Test
        void 업데이트(){
            User beforeUser = (User) UserRepositoryTest.beforeUser;
            beforeUser.setUserName("db");
            Domain updateUser=repository.update(UserRepositoryTest.beforeUser);
            assertThat(UserRepositoryTest.beforeUser).isEqualTo(updateUser);
        }
    }

    @Nested
    class UserServiceTest{
        private Problem7Service userService= new Problem7Service();
        private Problem7SnsRepository repository= RepositoryFactory.makeProblem7SnsRepository();

        @AfterEach
        void after(){
            repository.removeAll();
        }

        @Test
        void 저장(){
            User user=new User("mrko");
            userService.save(user);
            User user1=new User("mrko");
            userService.save(user1);
            Optional<Domain> findUser = repository.findById(0);
            findUser.orElseThrow(()->new RuntimeException());
            assertThat(user).isEqualTo(findUser.get());
        }

        @Test
        void 친구추가(){
            User user=new User("mrko");
            User friend=new User("andole");
            userService.save(user);
            userService.save(friend);
            userService.addFriend(user.getUserName(),friend.getUserName());
            Iterator<User> friends = user.getFriends();
            assertThat(friend).isEqualTo(friends.next());
        }

        @Test
        void 친구추천(){
            User user = new User("mrko");
            User friend=new User("andole");
            User andoleFriend=new User("jun");
            List<String> visitors = List.of();
            repository.save(user);
            repository.save(friend);
            repository.save(andoleFriend);

            userService.addFriend(user.getUserName(),friend.getUserName());
            userService.addFriend(friend.getUserName(),andoleFriend.getUserName());

            List<User> result=userService.suggestUser(user,visitors);

            assertThat(andoleFriend).isEqualTo(result.get(0));
        }
    }
}
