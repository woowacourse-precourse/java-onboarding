package onboarding.problem6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmailSorter implements ResultStyleFormatter {

	private List<String> getEmails(List<Crew> crews) {
		List<String> emails = new ArrayList<>();
		for (Crew crew : crews) {
			emails.add(crew.getEmail());
		}
		return emails;
	}

	private List<String> sortEmails(List<String> emails) {
		Collections.sort(emails);
		return emails;
	}

	@Override
	public List<String> getResult(List<Crew> crews) {
		List<String> emails = getEmails(crews);
		List<String> sortedEmails = sortEmails(emails);
		return sortedEmails;
	}
}
