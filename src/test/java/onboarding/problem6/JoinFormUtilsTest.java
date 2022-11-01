package onboarding.problem6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.Test;

public class JoinFormUtilsTest {

	private final static JoinFormUtils JOIN_FORM_UTILS = new JoinFormUtils();
	@Test
	public void 닉네임_중복_처리_테스트() {
	    //given
		String input = "제이엠";
		String input2 = "제이슨";
		String input3 = "엠제이";
		String input4 = "이제엠";

	    //when
		JOIN_FORM_UTILS.join(input);
		JOIN_FORM_UTILS.join(input2);
		JOIN_FORM_UTILS.join(input3);
		JOIN_FORM_UTILS.join(input4);
	    //then
		Set<String> duplicateNickNames = JOIN_FORM_UTILS.getDuplicateNickNames();
		assertThat(duplicateNickNames)
			.containsExactlyInAnyOrder(input, input2, input3);
	}
}
