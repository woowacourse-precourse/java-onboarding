package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class RepetitionListTest {

	@Test
	void add_repetition() {
		RepetitionList repetitionListJason = new RepetitionList();
		RepetitionList repetitionListJasonTest = new RepetitionList();
		repetitionListJason.add("제이슨");

		repetitionListJasonTest.add(List.of("제이", "이슨"));
		assertThat(repetitionListJason).isEqualTo(repetitionListJasonTest);
	}
}
