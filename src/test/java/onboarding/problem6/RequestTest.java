package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RequestTest {

	private static final String EMAIL_EXAMPLE = "test@email.com";

	@ParameterizedTest(name = "닉네임에 중복이 있는지 알 수 있다")
	@CsvSource(value = {"제이엠,제이슨,true", "가나다라,다,false", "가다가다,가가,false", "가이슨,나이슨,true"})
	void check_if_nickname_has_overlap(String nickname1, String nickname2, boolean expected) {
		Request request1 = new Request(EMAIL_EXAMPLE, nickname1);
		Request request2 = new Request(EMAIL_EXAMPLE, nickname2);

		assertThat(request1.hasOverlapOf(request2)).isEqualTo(expected);
	}
}
