package onboarding.problem3.game369;

import java.util.HashSet;
import java.util.Set;

import onboarding.problem3.CountPool;

public class Game369CountPool implements CountPool {

	private Set<Integer> specificNumberSet;

	public Game369CountPool() {
		specificNumberSet = new HashSet<>();
		setByGameRule();
	}

	private void setByGameRule() {
		specificNumberSet = new HashSet<>();
		specificNumberSet.add(3);
		specificNumberSet.add(6);
		specificNumberSet.add(9);
	}

	@Override
	public boolean countable(int number) {
		return specificNumberSet.contains(number);
	}


}
