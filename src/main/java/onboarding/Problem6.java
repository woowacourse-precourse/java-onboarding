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
		HashMap<String, String> crewApplicationData = new HashMap<>();
		inputApplicationData(forms, crewApplicationData);

		Collection<String> crewNicknamesToCheck = crewApplicationData.values();
		HashSet<String> organizedEmailsToBeSent = new HashSet<>();

		for (String name : crewNicknamesToCheck) {
			for (int j = 0; j <= name.length() - 2; j++) {
				String checkingWords = name.substring(j, j + 2);

				Set<String> emailsToBeSent = getEmailsToBeSent(crewApplicationData, checkingWords);
				checkDuplicateEmail(organizedEmailsToBeSent, emailsToBeSent);
			}
		}

		Set<String> sortedEmailsToBeSent = getSortedSet(organizedEmailsToBeSent);

		return toList(sortedEmailsToBeSent);
	}

	private static void inputApplicationData(List<List<String>> forms, HashMap<String, String> crewApplicationData) {
		for (List<String> form : forms) {
			crewApplicationData.put(form.get(0), form.get(1));
		}
	}

	private static Set<String> getEmailsToBeSent(HashMap<String, String> crewApplicationData, String checkingWords) {
		return crewApplicationData.entrySet().stream()
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
