package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SNSSystemTest {

	@Test
	void second_friends() {
		SNSSystem snsSystem = new SNSSystem();

		snsSystem.add(List.of("jack", "jun"));
		snsSystem.add(List.of("kim", "jun"));

		assertThat(snsSystem.getFriendOfFriend("jack")).isEqualTo(List.of("kim"));
	}
}
