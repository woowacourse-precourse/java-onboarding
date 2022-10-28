package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;

public class RecommendationSystem {
	List<String> userFriends;
	List<String> candidates;
	List<Integer> points;

	public RecommendationSystem() {
		userFriends = new ArrayList<>();
		candidates = new ArrayList<>();
		points = new ArrayList<>();
	}

	// 기능1. user와 친구인 사람을 찾는다.
	public void findUserFriend(List<List<String>> friends, String user) {
		for (List<String> relation : friends) {
			// 친구가 있을 경우 친구의 인덱스를 리턴 없으면 -1리턴
			int determination = isFriend(relation, user);
			if (determination == -1) {
				continue;
			}
			// 유저의 친구 목록에 저장한다.
			userFriends.add(relation.get(determination));
		}
	}

	// 기능2. 관계확인 함수를 이용해서 친구관계인지 아닌지 판단한다.
	public int isFriend(List<String> relation, String user) {
		if (user.equals(relation.get(0))) {
			// 1번이 친구인 경우
			return 1;
		} else if (user.equals(relation.get(1))) {
			// 0번이 친구인 경우
			return 0;
		}
		// 친구가 아닌 경우
		return -1;
	}

	public int searchCandidates(String friend) {
		if (candidates.isEmpty()) {
			candidates.add(friend);
			return 0;
		}

		int index = 0;
		for (String name : candidates) {
			if (name.equals(friend)) {
				return index;
			}
			index++;
		}

		candidates.add(friend);
		return index;
	}
}
