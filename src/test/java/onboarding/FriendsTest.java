package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class FriendsTest {
    @DisplayName("중복되는 친구의 수를 계산한다.")
    @Test
    void sameFriendsCount() {
        Friends mrkoFriends = new Friends(List.of("donut", "andole", "jun"));
        Friends shakevanFriends = new Friends(List.of("jun", "mrko", "donut", "andole"));
        Friends andoleFriends = new Friends(List.of("jun"));

        int count1 = mrkoFriends.sameFriendsCount(shakevanFriends);
        int count2 = mrkoFriends.sameFriendsCount(andoleFriends);

        assertAll(
                () -> assertThat(count1).isEqualTo(3),
                () -> assertThat(count2).isEqualTo(1)
        );
    }
}
