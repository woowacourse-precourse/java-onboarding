package onboarding.problem7;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserTest {

    @Test
    void 사용자를_처음_생성하면_추천점수는_0입니다() {
        var user = new User("user1");

        assertThat(user.isZeroScore()).isTrue();
    }

    @Test
    void 사용자와_다른_사용자는_친구관계를_설정할_수_있습니다() {
        var user   = new User("user1");
        var friend = new User("friend");

        user.addFriend(friend);

        assertThat(user.isFriend(friend)).isTrue();
    }

    @Test
    void 사용자와_다른_사용자가_친구관계를_설정하면_다른_곳에서도_자동으로_친구_관계가_등록됩니다() {
        var user   = new User("user1");
        var friend = new User("friend");

        user.addFriend(friend);

        assertThat(friend.isFriend(user)).isTrue();
    }

    @Test
    void 사용자가_중복된_이름을_가진_사용자를_추가할때_기존에_추가되어있다면_등록되지_않습니다() {
        var user   = new User("user1");
        var friend = new User("friend");

        user.addFriend(friend);
        user.addFriend(friend);

        friend.addFriend(user);


        assertThat(user.friends()).hasSize(1);
        assertThat(friend.friends()).hasSize(1);
    }

    @Test
    void 사용자와_친구관계를_맺고_있는_사람의_경우_10점씩_추가합니다() {
        //given
        var user    = new User("user1");
        var friend  = new User("friend");
        var friends = List.of("friend1", "friend2", "friend3", "friend4");

        var friendAFriends = friends.stream()
                                    .map(User::new)
                                    .collect(Collectors.toList());
        friendAFriends.forEach(friend::addFriend);

        user.addFriend(friend);
        //when
        user.plusScoreCaseFriendsAFriend();

        friendAFriends.forEach(user1 -> {
            assertThat(user1.score()).isEqualTo(10);
        });
    }

    @Test
    void 사용자를_비교할때_비교의_기준이_되는것은_추천_점수입니다() {
        var user   = new User("user1");
        var friend = new User("firend");

        for (int i = 0; i < 10; i++) {
            user.plusScoreCaseVisitors();
        }
        friend.plusScoreCaseVisitors();

        assertThat(user).isGreaterThan(friend);
    }

    @Test
    void 사용자를_비교할때_동일한_추천점수를_가지고_있을때_이름으로_비교합니다() {
        var user   = new User("a");
        var friend = new User("b");

        user.plusScoreCaseVisitors();
        friend.plusScoreCaseVisitors();

        assertThat(user).isGreaterThan(friend);
    }
}