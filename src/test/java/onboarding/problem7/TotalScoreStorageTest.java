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

	@Test
	void get_max_score_list() {
		TotalScoreStorage totalScoreStorage = new TotalScoreStorage();
		totalScoreStorage.add(List.of("mikea"), 7);
		totalScoreStorage.add(List.of("mikeb"), 5);
		totalScoreStorage.add(List.of("mikec"), 6);
		totalScoreStorage.add(List.of("miked"), 7);
		totalScoreStorage.add(List.of("mikee"), 8);
		totalScoreStorage.add(List.of("mikef"), 9);
		totalScoreStorage.add(List.of("mikeg"), 10);

		Assertions.assertThat(totalScoreStorage.getRecommendedFriends())
			.isEqualTo(List.of("mikeg", "mikef", "mikee", "mikea", "miked"));

	}

}
