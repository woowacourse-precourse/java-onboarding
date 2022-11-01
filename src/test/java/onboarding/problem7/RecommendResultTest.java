package onboarding.problem7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RecommendResultTest {

	@Test
	public void 친구_추천_테스트() {
		String inputUserId = "mrko";
		List<List<String>> inputFriends = Arrays.asList(Arrays.asList("donut", "andole"),
			Arrays.asList("donut", "jun"), Arrays.asList("donut", "mrko"),
			Arrays.asList("shakevan", "andole"), Arrays.asList("shakevan", "jun"),
			Arrays.asList("shakevan", "mrko"));

		List<String> inputVisitors = Arrays.asList("bedi", "bedi", "donut", "bedi", "shakevan");

		RecommendResult recommendResult = new RecommendResult(inputUserId, inputFriends,
			inputVisitors);
		List<String> result = recommendResult.getResult();
		assertThat(Arrays.asList("andole", "jun", "bedi")).isEqualTo(result);
	}
}
