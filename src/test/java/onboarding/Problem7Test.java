package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Problem7Test {

	@Test
	void scoreClassTest() {
		String username = "kim";
		int score = 10;

		Problem7.Score user1 = new Problem7.Score(username, score);

		assertThat(user1).isInstanceOf(Problem7.Score.class);
		assertThat(user1.score).isEqualTo(10);

		user1.addScore10();
		assertThat(user1.score).isEqualTo(20);

		user1.addScore1();
		assertThat(user1.score).isEqualTo(21);
	}

	@Test
	@DisplayName("점수가 높은 순, 같은 점수라면 이름을 오름차순으로 가져야 한다.")
	void getScorePriorityQueueTest() {
		PriorityQueue<Problem7.Score> scorePriorityQueue = Problem7.getScorePriorityQueue();
		Problem7.Score user1 = new Problem7.Score("abe", 100);
		Problem7.Score user2 = new Problem7.Score("abc", 100);
		Problem7.Score user3 = new Problem7.Score("abd", 100);
		Problem7.Score user4 = new Problem7.Score("efg", 101);
		Problem7.Score user5 = new Problem7.Score("aaa", 99);

		scorePriorityQueue.add(user1);
		scorePriorityQueue.add(user2);
		scorePriorityQueue.add(user3);
		scorePriorityQueue.add(user4);
		scorePriorityQueue.add(user5);

		assertThat(scorePriorityQueue.poll()).isSameAs(user4);
		assertThat(scorePriorityQueue.poll()).isSameAs(user2);
		assertThat(scorePriorityQueue.poll()).isSameAs(user3);
		assertThat(scorePriorityQueue.poll()).isSameAs(user1);
		assertThat(scorePriorityQueue.poll()).isSameAs(user5);
	}
}
