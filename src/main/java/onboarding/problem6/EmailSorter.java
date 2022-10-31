package onboarding.problem6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmailSorter implements ResultStyleFormatter {

	private List<String> getEmails(List<Crew> crews) {
		Set<String> emails = new HashSet<>();
		for (Crew crew : crews) {
			emails.add(crew.getEmail());
		}
		return new ArrayList<>(emails);
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
