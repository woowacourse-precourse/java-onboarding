package onboarding.problem7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FriendTest {
    @Test
    void getFriend() {
        List<SnsId> snsIds = List.of(new SnsId("hobbang"),
                new SnsId("hodduck"));
        Friend friend = new Friend(snsIds);

        assertThat(friend.getFriend()).isEqualTo(snsIds);
    }

    @Test
    void if_over_max() {
        List<SnsId> snsIds = List.of(new SnsId("hobbang"),
                new SnsId("hodduck"),
                new SnsId("jjinppang"));

        assertThrows(FriendsException.class, () -> new Friend(snsIds));
    }
}
