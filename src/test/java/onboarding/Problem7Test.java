package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Problem7Test {

	@Test
	void getFriendsHashMapTest() {
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);

		Map<String, ArrayList<String>> friendsHashMap = Problem7.getFriendsHashMap(friends);
		ArrayList<String> donutFriends = friendsHashMap.get("donut");
		ArrayList<String> andoleFriends = friendsHashMap.get("andole");
		ArrayList<String> junFriends = friendsHashMap.get("jun");
		ArrayList<String> mrkoFriends = friendsHashMap.get("mrko");
		ArrayList<String> shakevanFriends = friendsHashMap.get("shakevan");
		ArrayList<String> bediFriends = friendsHashMap.get("bedi");

		assertThat(donutFriends.size()).isEqualTo(3);
		assertTrue(donutFriends.contains("andole"));
		assertTrue(donutFriends.contains("jun"));
		assertTrue(donutFriends.contains("mrko"));
		assertThat(andoleFriends.size()).isEqualTo(2);
		assertThat(junFriends.size()).isEqualTo(2);
		assertThat(mrkoFriends.size()).isEqualTo(2);
		assertThat(shakevanFriends.size()).isEqualTo(3);
		assertThat(bediFriends).isNull();
	}

	@Test
	void addScoreToTwoHopUsersTest() {
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		String user = "mrko";
		HashMap<String, Integer> userScoreHashMap = Problem7.userScoreHashMap;

		HashMap<String, ArrayList<String>> friendsHashMap = Problem7.getFriendsHashMap(friends);
		ArrayList<String> friendsList = friendsHashMap.get(user);
		HashSet<String> excludeUser = new HashSet<>(friendsList);
		excludeUser.add(user);
		Problem7.addScoreToTwoHopUsers(friendsHashMap, friendsList, excludeUser);

		assertThat(userScoreHashMap.get("andole")).isEqualTo(20);
		assertThat(userScoreHashMap.get("jun")).isEqualTo(20);
		assertThat(userScoreHashMap.get("donut")).isNull();
		assertThat(userScoreHashMap.get("mrko")).isNull();
		assertThat(userScoreHashMap.get("shakevan")).isNull();
		assertThat(userScoreHashMap.get("bedi")).isNull();
	}

	@Test
	void setUserScoreHashMapTest() {
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		String user = "mrko";
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		HashMap<String, Integer> userScoreHashMap = Problem7.userScoreHashMap;

		HashMap<String, ArrayList<String>> friendsHashMap = Problem7.getFriendsHashMap(friends);
		Problem7.setUserScoreHashMap(user, friendsHashMap, visitors);

		assertThat(userScoreHashMap.get("jun")).isEqualTo(20);
		assertThat(userScoreHashMap.get("andole")).isEqualTo(20);
		assertThat(userScoreHashMap.get("donut")).isNull();
		assertThat(userScoreHashMap.get("mrko")).isNull();
		assertThat(userScoreHashMap.get("shakevan")).isNull();
		assertThat(userScoreHashMap.get("bedi")).isEqualTo(3);
	}
}
