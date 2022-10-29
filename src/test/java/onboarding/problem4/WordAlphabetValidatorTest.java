package onboarding.problem4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WordAlphabetValidatorTest {

	@Test
	void validate_alphabet() {
		WordAlphabetValidator wordAlphabetValidator = new WordAlphabetValidator();
		assertThat(wordAlphabetValidator.validate('1')).isFalse();
		assertThat(wordAlphabetValidator.validate('*')).isFalse();

		assertThat(wordAlphabetValidator.validate('a')).isTrue();
		assertThat(wordAlphabetValidator.validate('A')).isTrue();
	}
}
