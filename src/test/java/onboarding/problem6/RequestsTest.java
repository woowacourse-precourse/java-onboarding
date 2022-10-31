package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RequestsTest {

	public static final List<List<String>> FORMS = List.of(
		List.of("jm@email.com", "제이엠"),
		List.of("jason@email.com", "제이슨"),
		List.of("woniee@email.com", "워니"),
		List.of("mj@email.com", "엠제이"),
		List.of("nowm@email.com", "이제엠")
	);

	@Test
	@DisplayName("결과는 이메일을 오름차순으로 정렬한다")
	void results_are_sorted_in_ascending_order() {
		List<List<String>> shuffledForms = new ArrayList<>(FORMS);
		Collections.shuffle(shuffledForms);
		List<String> expectedEmailsOfOverlappedCrews = List.of("jason@email.com", "jm@email.com", "mj@email.com");

		Requests requests = new Requests(shuffledForms);

		assertThat(requests.getEmailsOfOverlappedCrews()).containsExactlyElementsOf(expectedEmailsOfOverlappedCrews);
	}
}
