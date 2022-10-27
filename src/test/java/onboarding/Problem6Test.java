package onboarding;

import static org.assertj.core.api.Assertions.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem6Test {

	@Test
	void integrationTest() {
		// given
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

		// when
		List<String> duplicatedUserEmailAscendingList = Problem6.solution(forms);

		// then
		assertThat(duplicatedUserEmailAscendingList.size()).isEqualTo(6);
		assertThat(duplicatedUserEmailAscendingList.get(0)).isEqualTo("darama@email.com");
		assertThat(duplicatedUserEmailAscendingList.get(1)).isEqualTo("ganada@email.com");
		assertThat(duplicatedUserEmailAscendingList.get(2)).isEqualTo("jason@email.com");
		assertThat(duplicatedUserEmailAscendingList.get(3)).isEqualTo("jm@email.com");
		assertThat(duplicatedUserEmailAscendingList.get(4)).isEqualTo("mj@email.com");
		assertThat(duplicatedUserEmailAscendingList.get(5)).isEqualTo("nadara@email.com");
	}

	@Test
	void getStringEmailHashMapTest() {
		// given
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "제이엠"),
			List.of("jason@email.com", "제이슨"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("nowm@email.com", "이제엠")
		);

		// when
		HashMap<String, ArrayList<String>> stringEmailHashMap = Problem6.getStringEmailHashMap(forms);

		// then
		assertThat(stringEmailHashMap.size()).isEqualTo(7);
		assertThat(stringEmailHashMap.get("제이").size()).isEqualTo(3);
		assertThat(stringEmailHashMap.get("워니").size()).isEqualTo(1);
		Assertions.assertTrue(stringEmailHashMap.get("제이").contains("jm@email.com"));
		Assertions.assertTrue(stringEmailHashMap.get("제이").contains("jason@email.com"));
		Assertions.assertTrue(stringEmailHashMap.get("제이").contains("mj@email.com"));
	}

	@Test
	void getDuplicatedUserEmailHashSetTest() {
		// given
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "제이엠"),
			List.of("jason@email.com", "제이슨"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("nowm@email.com", "이제엠")
		);

		// when
		HashSet<String> duplicatedUserEmailHashSet = Problem6.getDuplicatedUserEmailHashSet(forms);

		// then
		assertThat(duplicatedUserEmailHashSet.size()).isEqualTo(3);
		Assertions.assertTrue(duplicatedUserEmailHashSet.contains("jm@email.com"));
		Assertions.assertTrue(duplicatedUserEmailHashSet.contains("jason@email.com"));
		Assertions.assertTrue(duplicatedUserEmailHashSet.contains("mj@email.com"));
		Assertions.assertFalse(duplicatedUserEmailHashSet.contains("woniee@email.com"));
		Assertions.assertFalse(duplicatedUserEmailHashSet.contains("nowm@email.com"));
	}
}
