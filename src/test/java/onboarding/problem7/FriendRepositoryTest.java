package onboarding.problem7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class FriendRepositoryTest {
@Test
public void 친구_관계_테스트() {
    //given
	Friend friend = new Friend(Arrays.asList("donut", "mrko"));
	//when
	boolean isFriend = FriendRepository.isFriend("donut", "mrko");
	//then
	assertThat(isFriend).isTrue();
}
}
