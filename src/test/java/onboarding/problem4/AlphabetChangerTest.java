package onboarding.problem4;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.Test;

public class AlphabetChangerTest {

	@Test
	void alphabet_change(){
		AlphabetChanger alphabetChanger = new AlphabetChanger();
		assertThat(alphabetChanger.change('a')).isEqualTo('z');
		assertThat(alphabetChanger.change('z')).isEqualTo('a');
		assertThat(alphabetChanger.change('A')).isEqualTo('Z');
		assertThat(alphabetChanger.change('Z')).isEqualTo('A');

	}
}
