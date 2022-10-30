package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class NicknameSplitterTest {

	@Test
	void split_nickname_to_repetition() {
		NicknameSplitter nicknameSplitter = new NicknameSplitter();
		assertThat(nicknameSplitter.split("제이슨")).isEqualTo(List.of("제이", "이슨"));

		assertThat(nicknameSplitter.split("제")).isEqualTo(Collections.EMPTY_LIST);
	}
}
