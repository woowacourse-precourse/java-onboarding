package onboarding.friendrecommendationsystem;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class CrewsTest {

	static List<List<String>> forms = List.of(
		List.of("jm@email.com", "제이엠"),
		List.of("jason@email.com", "제이슨"),
		List.of("woniee@email.com", "워니"),
		List.of("mj@email.com", "엠제이"),
		List.of("nowm@email.com", "이제엠")
	);

	@DisplayName("총 크루원 수 검증")
	@Test
	void 특정_단어_횟수() {
		assertThatThrownBy(
			() -> new Crews(List.of(List.of("", "")))
		).isInstanceOf(IllegalArgumentException.class);

		assertThat(new Crews(forms)).isNotNull();
	}

	@DisplayName("중복된 단어들을 포함하는 각 크루원의 목록을 구할 수 있다.")
	@Test
	void 중복단어_포함_크루원_목록_반환() {
		Crews crews = new Crews(forms);
		Map<String, Set<Crew>> crewsOfDuplicateNickname
			= crews.getCrewsOfDuplicateNickname();

		assertThat(
			crewsOfDuplicateNickname.get("제이").size()
		).isEqualTo(3);

		assertThat(
			crewsOfDuplicateNickname.get("제엠").size()
		).isEqualTo(1);
	}

	@DisplayName("중복된 단어들을 포함하는 크루원들의 이메일들을 구할 수 있다.")
	@Test
	void 중복단어_포함_크루원_닉네임_반환() {
		Crews crews = new Crews(forms);
		List<String> emails = crews.getInvalidEmails();
		assertThat(emails).containsAll(
			List.of("jason@email.com", "jm@email.com", "mj@email.com")
		);
	}

}
