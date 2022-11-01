package onboarding.problem6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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

	@Test
	public void 중복_닉네임_이메일_찾기_테스트() {
	    //given
		List<List<String>> forms = Arrays.asList(
			Arrays.asList("jm@email.com", "제이엠"), Arrays.asList("jason@email.com", "제이슨"), Arrays.asList("woniee@email.com", "워니"),
			Arrays.asList("mj@email.com", "엠제이"), Arrays.asList("nowm@email.com", "이제엠"));
		JOIN_FORM_UTILS.join(forms);
	    //when
		List<String> result = JOIN_FORM_UTILS.findEmailsByDuplicateNickNames();
	    //then
		assertThat(Arrays.asList("jason@email.com", "jm@email.com", "mj@email.com"))
			.isEqualTo(result);
	}
}
