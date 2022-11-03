package onboarding.friendrecommendationsystem;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

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
}
