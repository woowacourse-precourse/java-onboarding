package onboarding.problem6;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class RepetitionList {

	private final Set<String> repetitionList = new HashSet<>();

	public void add(String name) {
		NicknameSplitter nicknameSplitter = new NicknameSplitter();
		List<String> repetitions = nicknameSplitter.split(name);
		add(repetitions);
	}

	public void add(List<String> repetitions) {
		repetitionList.addAll(repetitions);
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

	public boolean isRepeat(String str) {
		NicknameSplitter nicknameSplitter = new NicknameSplitter();
		List<String> split = nicknameSplitter.split(str);
		return split.stream()
			.anyMatch(repetitionList::contains);
	}
}
