package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class SimilarNicknameCrewSelector {
	private List<List<String>> crewInformations;
	private final int numberOfCrews;
	private List<Boolean> hasSimilarNickname;
	private List<String> similarNicknameCrewsEmail;

	public SimilarNicknameCrewSelector(List<List<String>> forms) {
		this.crewInformations = new ArrayList<>(forms);
		this.numberOfCrews = forms.size();
		this.hasSimilarNickname = new ArrayList<>();
		this.similarNicknameCrewsEmail = new ArrayList<>();

		for (int i = 0; i < this.numberOfCrews; i++) {
			this.hasSimilarNickname.add(false);
		}
	}

}
