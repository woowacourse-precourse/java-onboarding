package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VisitTest {

	@Test
	@DisplayName("방문 횟수를 알 수 있다")
	void count_timeline_visit() {
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		Visit visitor = new Visit(visitors);

		assertThat(visitor.count("bedi")).isEqualTo(3);
	}
}
