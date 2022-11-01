package onboarding.problem6.util.duplication.model;

import java.util.Objects;

import onboarding.problem6.util.duplication.Duplicative;

public class InNickName implements Duplicative {
	private String word;

	public InNickName(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InNickName that = (InNickName)o;
		return Objects.equals(getWord(), that.getWord());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getWord());
	}
}
