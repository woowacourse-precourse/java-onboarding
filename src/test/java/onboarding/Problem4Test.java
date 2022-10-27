package onboarding;

import static onboarding.Problem4.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class Problem4Test {

	@Test
	void integrationTest() {
		assertThat(solution("I love you")).isEqualTo("R olev blf");
		assertThat(solution("123 $..$ 456")).isEqualTo("123 $..$ 456");
	}

	@Test
	void getHashMapFrogDictTest() {
		HashMap<Character, Character> frogDict = getHashMapFrogDict();
		assertThat(frogDict.get('A')).isEqualTo('Z');
		assertThat(frogDict.get('D')).isEqualTo('W');
		assertThat(frogDict.get('P')).isEqualTo('K');
		assertThat(frogDict.get('Y')).isEqualTo('B');

		assertThat(frogDict.get('b')).isEqualTo('y');
		assertThat(frogDict.get('y')).isEqualTo('b');
		assertThat(frogDict.get('i')).isEqualTo('r');
		assertThat(frogDict.get('m')).isEqualTo('n');
	}
}
