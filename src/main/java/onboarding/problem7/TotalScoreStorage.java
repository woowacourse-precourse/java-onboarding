package onboarding.problem7;

import java.util.HashMap;
import java.util.List;

public class TotalScoreStorage {
	private final HashMap<String,Integer> scoreList;

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
}
