package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import onboarding.Problem6.Member;
import onboarding.Problem6.NicknameChecker;

public class NicknameCheckerTest {

	@Nested
	class GroupBySubstringInNickname {

		@Test
		void case1() throws Exception {
			// given
			final List<Member> members = Stream.of(
					List.of("jm@email.com", "제이엠"),
					List.of("jason@email.com", "제이슨"),
					List.of("woniee@email.com", "워니"),
					List.of("mj@email.com", "엠제이"),
					List.of("nowm@email.com", "이제엠")
				)
				.map(Member::of)
				.collect(Collectors.toList());

			// when
			final Map<String, List<Member>> memberMap = NicknameChecker.groupBySubstringInNickname(members);

			// then
			assertThat(memberMap.get("제이").size()).isEqualTo(3);
		}

	}

}
