package onboarding.problem6;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class RepetitionList {

	private final Set<String> repetitionList = new HashSet<>();

	public void add(String name) {
		int start = 1;
		while (start < name.length()) {
			repetitionList.add(name.substring(start - 1, start + 1));
			start++;
		}
	}

	public void add(List<String> names) {
		repetitionList.addAll(names);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof RepetitionList))
			return false;
		RepetitionList that = (RepetitionList)o;
		return Objects.equals(repetitionList, that.repetitionList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(repetitionList);
	}
}
