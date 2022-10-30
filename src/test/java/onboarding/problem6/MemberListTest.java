package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MemberListTest {

	@Test
	void member_list_range() {
		MemberList memberList = new MemberList();
		assertThat(memberList.isFull(100000)).isTrue();
	}
}
