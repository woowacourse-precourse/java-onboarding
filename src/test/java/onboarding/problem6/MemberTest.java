package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class MemberTest {

	@Test
	void new_member() {
		Member member = new Member(List.of("jm@email.com", "제이엠"));
		assertThat(member).isEqualTo(new Member("jm@email.com", "제이엠"));
	}

}
