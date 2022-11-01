package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;

public class Problem7 {
	private static String checkAlreadyFriends(String user, List<String> relation) {
		String output;
		if (relation.get(0).equals(user)) {
			output = relation.get(1);
			return output;
		}
		if (relation.get(1).equals(user)) {
			output = relation.get(0);
			return output;
		}
		output = "";
		return output;
	}

	private static List<String> findAlreadyFriends(String user, List<List<String>> friends) {
		List<String> output = new ArrayList<>();
		int length = friends.size();
		String temp;
		for (int i = 0; i < length; i++) {
			temp = checkAlreadyFriends(user, friends.get(i));
			if (!temp.equals("") && !output.contains(temp)) {
				output.add(temp);
			}
		}
		return output;
	}

	private static void addScore(String member, int scoreUnit, HashMap<String, Integer> scores) {
		int tempScore;
		if (!scores.containsKey(member)) {
			scores.put(member, scoreUnit);
		} else {
			tempScore = scores.get(member);
			tempScore += scoreUnit;
			scores.put(member, tempScore);
		}
	}

	private static List<String> getAnswer(HashMap<String, Integer> scores){
		List<String> answer = new ArrayList<>(scores.keySet());
		answer.sort(Comparator.naturalOrder());
		answer.sort((s1, s2) -> scores.get(s2) - scores.get(s1));
		if (answer.size() > 5) {
			answer = answer.subList(0, 5);
		}
		return answer;
	}

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		HashMap<String, Integer> scores = new HashMap<>();
		List<String> alreadyFriends = findAlreadyFriends(user, friends);
		String temp;
		for (int i = 0; i < friends.size(); i++) {
			for (int j = 0; j < alreadyFriends.size(); j++) {
				temp = checkAlreadyFriends(alreadyFriends.get(j), friends.get(i));
				if (!temp.equals("") && !temp.equals(user) && !alreadyFriends.contains(temp)) {
					addScore(temp, 10, scores);
				}
			}
		}
		for (int i = 0; i < visitors.size(); i++) {
			if (!alreadyFriends.contains(visitors.get(i))) {
				addScore(visitors.get(i), 1, scores);
			}
		}
		List<String> answer = getAnswer(scores);
		return answer;
	}
}
