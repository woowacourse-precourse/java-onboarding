package onboarding;

import static org.assertj.core.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

class Problem6Test {

	@Nested
	class IntegrationTest {
		@Test
		void integrationTest1() {
			List<List<String>> forms = List.of(
				List.of("jm@email.com", "제이엠"),
				List.of("jason@email.com", "제이슨"),
				List.of("woniee@email.com", "워니"),
				List.of("mj@email.com", "엠제이"),
				List.of("nowm@email.com", "이제엠"),
				List.of("ganada@email.com", "가나다"),
				List.of("nadara@email.com", "나다라"),
				List.of("darama@email.com", "다라마")
			);
			List<String> result = List.of("darama@email.com", "ganada@email.com", "jason@email.com", "jm@email.com", "mj@email.com", "nadara@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}
		@Test
		void integrationTest2() {
			List<List<String>> forms = List.of(
				List.of("jason@email.com", "제이슨"),
				List.of("mj@email.com", "엠제이"),
				List.of("onepiece@email.com", "원피수"),
				List.of("onepisu@email.com", "원피수"),
				List.of("suonepi@email.com", "수원피")
			);
			List<String> result = List.of("jason@email.com", "mj@email.com", "onepiece@email.com", "onepisu@email.com", "suonepi@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}

		@Test
		void case2() {
			List<List<String>> forms = List.of();
			assertThat(Problem6.solution(forms)).isNullOrEmpty();
		}
	}

	@Test
	void integrationTest2() {
		List<List<String>> forms = List.of(
			List.of("onepiece@email.com", "원피수"),
			List.of("jason@email.com", "제이슨"),
			List.of("onepisu@email.com", "원피수"),
			List.of("mj@email.com", "엠제이"),
			List.of("suonepi@email.com", "수원피")
		);
		List<String> result = List.of("jason@email.com", "mj@email.com", "onepiece@email.com", "onepisu@email.com", "suonepi@email.com");
		assertThat(Problem6.solution(forms)).isEqualTo(result);
	}

	@Test
	void integrationTest3() {
		List<List<String>> forms = List.of(
			List.of("kim@email.com", "김ㅡ이"),
			List.of("nam@email.com", "ㅡ이야"),
			List.of("choi@email.com", "최강"),
			List.of("lee@email.com", "강합니다"),
			List.of("jun@email.com", "왜ㅇㅡ이야")
		);
		List<String> result = List.of("jun@email.com", "kim@email.com", "nam@email.com");
		assertThat(Problem6.solution(forms)).isEqualTo(result);
	}

	@Test
	void getStringEmailHashMapTest() {
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "제이엠"),
			List.of("jason@email.com", "제이슨"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("nowm@email.com", "이제엠")
		);

		HashMap<String, ArrayList<String>> stringEmailHashMap = Problem6.getStringEmailMap(forms);

		assertThat(stringEmailHashMap.size()).isEqualTo(7);
		assertThat(stringEmailHashMap.get("제이").size()).isEqualTo(3);
		assertThat(stringEmailHashMap.get("워니").size()).isEqualTo(1);
		Assertions.assertTrue(stringEmailHashMap.get("제이").contains("jm@email.com"));
		Assertions.assertTrue(stringEmailHashMap.get("제이").contains("jason@email.com"));
		Assertions.assertTrue(stringEmailHashMap.get("제이").contains("mj@email.com"));
	}

	@Test
	void getDuplicatedUserEmailSetTest() {
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "제이엠"),
			List.of("jason@email.com", "제이슨"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("nowm@email.com", "이제엠")
		);

		Set<String> duplicatedUserEmailSet = Problem6.getDuplicatedUserEmailSet(forms);

		assertThat(duplicatedUserEmailSet.size()).isEqualTo(3);
		Assertions.assertTrue(duplicatedUserEmailSet.contains("jm@email.com"));
		Assertions.assertTrue(duplicatedUserEmailSet.contains("jason@email.com"));
		Assertions.assertTrue(duplicatedUserEmailSet.contains("mj@email.com"));
		Assertions.assertFalse(duplicatedUserEmailSet.contains("woniee@email.com"));
		Assertions.assertFalse(duplicatedUserEmailSet.contains("nowm@email.com"));
	}
}
