package onboarding.problem6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class NickNameUtilsTest {

	private final static NickNameUtils nickNameUtils = new NickNameUtils();
	@Test
	public void 닉네임_중복_처리_테스트() {
	    //given
		String input = "제이엠";
		String input2 = "제이슨";
		String input3 = "엠제이";
		String input4 = "이제엠";

	    //when
		nickNameUtils.join(input);
		nickNameUtils.join(input2);
		nickNameUtils.join(input3);
		nickNameUtils.join(input4);
	    //then
		Set<String> duplicateNickNames = nickNameUtils.getDuplicateNickNames();
		assertThat(duplicateNickNames)
			.containsExactlyInAnyOrder(input, input2, input3);
	}
}
