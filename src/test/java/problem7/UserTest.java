package problem7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    void 디폴트_친구추천리스트_만들기() {
        userService.addFriends(createFriends());
        List<String> result = userService.createAllUserIds("mrko");
        assertThat(result).containsOnly("donut", "andole", "jun", "shakevan");
    }

    @Test
    void 유저추천리스트중_주어진유저의_친구관계제외() {
        userService.addFriends(createFriends());
        List<String> result = userService.operateFriendCommendation("mrko");
        assertThat(result).containsOnly("andole", "jun");
    }

    @Test
    void 타임라인에_방문한횟수기준_점수부여() {
        userService.addFriends(createFriends());
        List<FriendCommendResponseDto> result =
                userService.operateFriendCommendation("mrko", List.of("bedi", "bedi", "donut", "bedi", "shakevan"));

        FriendCommendResponseDto bedi = result.get(2);
        assertThat(bedi.getUserId()).isEqualTo("bedi");
        assertThat(bedi.getScore()).isEqualTo(3);
    }

    @Test
    void 함께아는_친구의수_기준으로_점수부여() {
        userService.addFriends(createFriends());
        List<FriendCommendResponseDto> result =
                userService.operateFriendCommendation("mrko", List.of("bedi", "bedi", "donut", "bedi", "shakevan"));

        FriendCommendResponseDto andole = result.get(0);
        FriendCommendResponseDto jun = result.get(1);
        FriendCommendResponseDto bedi = result.get(2);
        assertThat(andole.getScore()).isEqualTo(20);
        assertThat(jun.getScore()).isEqualTo(20);
        assertThat(bedi.getScore()).isEqualTo(3);
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

    @CsvSource(value = {"0:andole:20", "1:jun:20", "2:pobi:10", "3:bedi:3", "4:anna:2"}, delimiter = ':')
    @ParameterizedTest
    void 점수가높은순_같으면이름순_최대5명선정(int index, String userId, int score) {
        userService.addFriends(createFriends2());
        List<FriendCommendResponseDto> result =
                userService.operateFriendCommendation("mrko",
                        List.of("bedi", "bedi", "donut", "bedi", "shakevan", "yuna", "anna", "anna"));

        assertThat(result.get(index).getUserId()).isEqualTo(userId);
        assertThat(result.get(index).getScore()).isEqualTo(score);
    }

    private List<List<String>> createFriends2() {
        List<List<String>> friends = new ArrayList<>();
        friends.add(List.of("donut", "jun"));
        friends.add(List.of("donut", "andole"));
        friends.add(List.of("donut", "mrko"));
        friends.add(List.of("shakevan", "andole"));
        friends.add(List.of("shakevan", "jun"));
        friends.add(List.of("shakevan", "mrko"));
        friends.add(List.of("pobi", "donut"));
        friends.add(List.of("yuna", "andole"));

        return friends;
    }
}
