package onboarding.problem7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class VisitorsTest {

	@Test
	public void 방문자_카운트_테스트() {
		//given
		List<String> inputVisitors = Arrays.asList("bedi", "bedi", "donut", "bedi", "shakevan");
		//when
		Visitors.init(inputVisitors);
		Integer visitCount = Visitors.getVisitCount("bedi");
		Integer visitCount2 = Visitors.getVisitCount("aaaa");
		//then
		assertThat(3).isEqualTo(visitCount);
		assertThat(0).isEqualTo(visitCount2);
	}
}
