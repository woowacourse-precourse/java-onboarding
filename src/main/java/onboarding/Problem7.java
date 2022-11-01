package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


// 클래스1. 추천후보들의 이름과 점수를 갖는 Candidate객체를 정의한다.
class Candidate {
	public String name;
	public int point;

	public Candidate(String name, int point) {
		this.name = name;
		this.point = point;
	}
}


// 클래스2. 점수에 따라 내림차순으로 정렬한 후, 동점이라면 이름순으로 정렬한다.
class CandidatesComparator implements Comparator<Candidate> {
	@Override public int compare(Candidate o1, Candidate o2) {
		if (o1.point > o2.point) {
			return -1;
		} else if (o1.point < o2.point) {
			return 1;
		}
		return isSamePoint(o1, o2);
	}

	private int isSamePoint(Candidate o1, Candidate o2) {
		String name1 = o1.name;
		String name2 = o2.name;
		return name1.compareTo(name2);
	}
}


public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends,
		List<String> visitors) {
		// user의 친구들을 찾는다.
		List<String> userFriends = getUserFriends(user, friends);

		// user의 친구 중에 user와 친구가 아닌 친구를 찾는고 점수를 부여한다.
		List<Candidate> candidatesForRecommend =
			getCandidatesForRecommend(user, friends, userFriends);
		// 방문자들을 찾아서 점수를 부여한다.
		getVisitorPoints(candidatesForRecommend, visitors, userFriends);

		List<String> recommendation = sortByAscendingOrder(candidatesForRecommend);
		return recommendation;
	}

	// 기능 1. user의 친구들을 찾는다.
	private static List<String> getUserFriends(String user, List<List<String>> friends) {
		List<String> list = new ArrayList<>();
		for (List<String> relation : friends) {
			// user의 친구의 이름을 찾아서 list에 저장한다.
			int friendIndex = getFriendIndex(user, relation);
			if (friendIndex == -1) {
				continue;
			}
			String friendName = relation.get(friendIndex);
			list.add(friendName);
		}
		return list;
	}

	// 기능 2. 친구의 친구를 찾아서 리스트를 만들고 점수를 부여한다.
	// 단, 이미 친구인 사람은 제외한다.
	private static List<Candidate> getCandidatesForRecommend(String user,
		List<List<String>> friends, List<String> userFriends) {
		List<Candidate> candidates = new ArrayList<>();

		for (String candidate : userFriends) {
			for (List<String> relation : friends) {
				int friendIndex = getFriendIndex(candidate, relation);
				// 목록에 없거나, 본인이거나, 이미 친구인 사람은 제외한다.
				if (isSkip(user, friendIndex, relation, userFriends)) {
					continue;
				}
				// 친구의 친구에게 점수 10점을 부여한다.
				getPointsByFriend(friendIndex, candidates, relation);
			}
		}

		return candidates;
	}

	// 기능3. 방문자에게 점수 1점을 부여한다.
	private static void getVisitorPoints(List<Candidate> candidatesForRecommend,
		List<String> visitors, List<String> userFriends) {
		for (String visitor : visitors) {
			// 후보목록에 있는지 확인한다.
			int nameIndex = getNameIndex(visitor, candidatesForRecommend);

			// user의 친구목록에 존재한다면 점수를 추가하지 않는다.
			if (isAlreadyFriend(nameIndex, visitor, userFriends)) {
				continue;
			}

			// 친구목록에 존재하지 않으면 새로 리스트에 추가한다.
			if (nameIndex == -1) {
				candidatesForRecommend.add(new Candidate(visitor, 1));
				continue;
			}
			// 후보 목록에 이미 존재한다면 1점을 올려 업데이트 한다.
			Candidate elemForUpdate = candidatesForRecommend.get(nameIndex);
			candidatesForRecommend.set(nameIndex,
				new Candidate(elemForUpdate.name, elemForUpdate.point + 1));
		}
	}

	// 기능 4. 추천목록을 점수순으로 정렬하고 동점일 경우 이름순으로 정렬한다.
	private static List<String> sortByAscendingOrder(List<Candidate> candidates) {
		candidates.sort(new CandidatesComparator());
		List<String> recommendation = new ArrayList<>();
		for (int i = 0; i < candidates.size(); i++) {
			if (i == 5) {
				break;
			}
			Candidate forRecommend = candidates.get(i);
			recommendation.add(forRecommend.name);
		}
		return recommendation;
	}

	// 기능 2-1. 친구관계가 아니거나, user본인이거나, 이미 친구관계인 경우 추가를 하지 않는다.
	private static boolean isSkip(String user, int friendIndex, List<String> relation,
		List<String> userFriends) {
		return isNoExistInRelation(friendIndex) || isSameAsUser(user, friendIndex, relation)
			|| isExistInUserFriends(friendIndex, relation, userFriends);
	}

	// 기능 2-2. 친구의 친구에게 점수 10점을 부여하고 candidates 목록에 저장한다.
	private static void getPointsByFriend(int friendIndex, List<Candidate> candidates,
		List<String> relation) {
		String candidateName = relation.get(friendIndex);
		int candidateIndex = getNameIndex(candidateName, candidates);
		if (candidateIndex != -1) {
			// 후보목록에 이미 있다면 인덱스로 접근해 10점을 추가로 준다.
			Candidate forUpdate = candidates.get(candidateIndex);
			forUpdate.point += 10;
			return;
		}
		// 후보목록에 없다면 후보목록에 점수 10점과 함께 추가한다.
		candidates.add(new Candidate(candidateName, 10));
	}

	// 기능 3-1. 후보목록에서 후보자의 인덱스를 찾는다. 목록에 없는 경우 -1을 반환
	private static int getNameIndex(String candidateName, List<Candidate> candidates) {
		for (int i = 0; i < candidates.size(); i++) {
			Candidate foundCandidate = candidates.get(i);
			String foundName = foundCandidate.name;
			if (foundName.equals(candidateName)) {
				// 목록에서 후보자의 인덱스를 찾았다면 인덱스를 반환한다.
				return i;
			}
		}
		// 목록에 없는 경우 -1을 반환
		return -1;
	}

	// 기능 1-1. relation에 user의 친구가 있는지 확인하고 친구의 index를 반환한다.
	private static int getFriendIndex(String user, List<String> relation) {
		String name0 = relation.get(0);
		String name1 = relation.get(1);

		if (user.equals(name0)) {
			// 유저가 index 0에 있으면 1을 반환
			return 1;
		} else if (user.equals(name1)) {
			// 유저가 index 1에 있으면 0을 반환
			return 0;
		}
		// 유저가 없으면, 즉 아무 관계도 아니면 -1 반환
		return -1;
	}

	// 기능 3-2. user의 친구목록에 존재하는 이름인지 확인한다.
	private static boolean isAlreadyFriend(int nameIndex, String visitor,
		List<String> userFriends) {
		for (String friend : userFriends) {
			// 존재하는 이름이라면 true를 반환
			if (nameIndex == -1 && friend.equals(visitor)) {
				return true;
			}
		}
		// 친구목록에 없다면 false를 반환
		return false;
	}

	// 기능 2-1-1. 친구관계가 아닌 경우를 판단
	private static boolean isNoExistInRelation(int friendIndex) {
		return friendIndex == -1;
	}

	// 기능 2-1-2. user본인인 경우를 판단
	private static boolean isSameAsUser(String user, int friendIndex, List<String> relation) {
		String candidateName = relation.get(friendIndex);
		return candidateName.equals(user);
	}

	// 기능 2-1-3. 이미 user와 친구관계인 경우를 판단
	private static boolean isExistInUserFriends(int friendIndex, List<String> relation,
		List<String> userFriends) {
		String candidateName = relation.get(friendIndex);

		int i;
		for (i = 0; i < userFriends.size(); i++) {
			// user와 친구인 목록을 돌면서 이름이 친구목록에 있는지 확인한다.
			if (userFriends.get(i).equals(candidateName)) {
				break;
			}
		}
		// user와 친구라면 true를 반환
		if (i != userFriends.size()) {
			return true;
		}
		// user와 친구가 아니라면 false를 반환
		return false;
	}
}
