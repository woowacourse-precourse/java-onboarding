package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberListTest {
	private MemberList memberList;
	private Member memberJm;
	private Member memberJason;

	@BeforeEach
	void setMemberList() {
		memberList = new MemberList();
		memberJm = new Member(List.of("jm@email.com", "제이엠"));
		memberJason = new Member(List.of("jason@email.com", "제이슨"));
	}

	@Test
	void member_list_range() {
		assertThat(memberList.isFull(100000)).isTrue();
	}

	@Test
	void add_member() {
		memberList.add(memberJm);
		memberList.add(memberJason);

		assertThat(memberList.containsMember(new Member(List.of("jm@email.com", "제이엠")))).isTrue();
		assertThat(memberList.containsMember(new Member(List.of("jason@email.com", "제이슨")))).isTrue();
	}

	@Test
	void find_repeat_member() {
		RepetitionList repetitionList = new RepetitionList();
		memberList.add(memberJason);
		memberList.add(new Member(List.of("woniee@email.com", "워니")));
		repetitionList.add("제이");
		assertThat(memberList.findRepeatMember(repetitionList).contains(memberJason)).isTrue();
		assertThat(memberList.findRepeatMember(repetitionList).contains(memberJm)).isFalse();

		memberList.add(memberJm);
		assertThat(memberList.findRepeatMember(repetitionList).contains(memberJm)).isTrue();
	}
}
