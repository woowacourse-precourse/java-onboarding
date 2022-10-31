package onboarding.problem7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TotalScoreStorage {
	private final HashMap<String, Integer> scoreList;

	public TotalScoreStorage() {
		this.scoreList = new HashMap<>();
	}

	public void add(List<String> list, int score) {
		list.forEach(name -> {
			scoreList.putIfAbsent(name, 0);
			scoreList.replace(name, scoreList.get(name) + score);
		});
	}

	public int getScore(String name) {
		return scoreList.get(name);
	}

	public List<String> getRecommendedFriends() {
		return scoreList.entrySet().stream()
			.sorted(recommendComparator())
			.map(Entry::getKey)
			.limit(5)
			.collect(Collectors.toList());
	}

	private static Comparator<Entry<String, Integer>> recommendComparator() {
		return (o1, o2) -> {
			if (o1.getValue().equals(o2.getValue())) {
				return o1.getKey().compareTo(o2.getKey());
			}
			return Integer.compare(o2.getValue(), o1.getValue());
		};
	}
}
