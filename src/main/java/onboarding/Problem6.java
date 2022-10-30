package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		HashMap<String, String> crewHashData = new HashMap<>();
		for (List<String> form : forms) {
			crewHashData.put(form.get(0), form.get(1));
		}

		Collection<String> crewNicknames = crewHashData.values();
		HashSet<String> organizedEmails = new HashSet<>();

		for (String name : crewNicknames) {
			for (int j = 0; j <= name.length() - 2; j++) {
				String checkingWords = name.substring(j, j + 2);

				Set<String> emailsToBeSent = getEmailsToBeSent(crewHashData, checkingWords);
				checkDuplicateEmail(organizedEmails, emailsToBeSent);
			}
		}

		Set<String> sortedEmails = getSortedSet(organizedEmails);

		return toList(sortedEmails);
	}

	private static Set<String> getEmailsToBeSent(HashMap<String, String> crewHashData, String checkingWords) {
		return crewHashData.entrySet().stream()
			.filter(entry -> entry.getValue().contains(checkingWords))
			.map(Map.Entry::getKey)
			.collect(Collectors.toSet());
	}

	private static void checkDuplicateEmail(HashSet<String> organizedEmails, Set<String> emails) {
		if (emails.size() > 1) {
			organizedEmails.addAll(emails);
		}
	}

	private static TreeSet<String> getSortedSet(HashSet<String> dispersedSet) {
		return new TreeSet<>(dispersedSet);
	}

	private static List<String> toList(Set<String> sortedEmails) {
		return new ArrayList<>(sortedEmails);
	}
}
