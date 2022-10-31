package onboarding.problem7;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TotalScoreStorageTest {

	@Test
	void add_point() {
		TotalScoreStorage totalScoreStorage = new TotalScoreStorage();
		totalScoreStorage.add(List.of("mike", "jerry"), 10);
		Assertions.assertThat(totalScoreStorage.getScore("mike")).isEqualTo(10);
		Assertions.assertThat(totalScoreStorage.getScore("jerry")).isEqualTo(10);

		totalScoreStorage.add(List.of("mike"), 20);
		Assertions.assertThat(totalScoreStorage.getScore("mike")).isEqualTo(30);
		Assertions.assertThat(totalScoreStorage.getScore("jerry")).isEqualTo(10);
	}

}
