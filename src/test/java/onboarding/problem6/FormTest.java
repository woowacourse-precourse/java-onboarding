package onboarding.problem6;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class FormTest {
	@Test
	public void 폼_유효성_테스트() {
	    //given
		List<String> correctFormInput = Arrays.asList("jm@email.com", "제이슨");
		List<String> wrongFormInput = Arrays.asList("jm@naver.com", "제이슨");
		List<String> wrongFormInput2 = Arrays.asList("jm@email.com", "제이슨2");

		assertThatThrownBy(() -> new Form(wrongFormInput))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Form(wrongFormInput2))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
