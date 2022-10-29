package onboarding.problem4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WordsRangeValidatorTest {

	@Test
	void word_range() {
		WordsRangeValidator wordValidator = new WordsRangeValidator();
		assertThat(wordValidator.validate(0)).isFalse();
		assertThat(wordValidator.validate(1001)).isFalse();
		assertThat(wordValidator.validate(1)).isTrue();
		assertThat(wordValidator.validate(1000)).isTrue();
	}
}
