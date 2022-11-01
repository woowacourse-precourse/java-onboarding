package onboarding.problem6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JoinFormUtils {

	private final Map<String, String> joinNickNames = new HashMap<>();
	private final Set<String> duplicateNickNames = new HashSet<>();
	private Map<String, String> forms;

	public void join(List<List<String>> inputForms) {
		forms = mapToForms(inputForms);
		for (String nickName : forms.keySet()) {
			join(nickName);
		}
	}

	Map<String, String> mapToForms(List<List<String>> forms) {
		return forms.stream()
			.map(Form::new)
			.collect(Collectors.toMap(Form::getNickName, Form::getEmail));
	}

	public void join(String input) {
		for (int startIndex = 0; input.length() - startIndex >= 2; startIndex++) {
			join(input, startIndex);
		}
	}

	void join(String input, int startIndex) {
		for (int endIndex = startIndex + 2; endIndex <= input.length(); endIndex++) {
			String substring = input.substring(startIndex, endIndex);
			if (joinNickNames.containsKey(substring)) {
				duplicateNickNames.add(input);
				duplicateNickNames.add(joinNickNames.get(substring));
				continue;
			}
			joinNickNames.put(substring, input);
		}
	}

	public List<String> findEmailsByDuplicateNickNames() {
		return duplicateNickNames.stream()
			.map(nickName -> this.forms.get(nickName))
			.distinct()
			.sorted()
			.collect(Collectors.toList());
	}

	Set<String> getDuplicateNickNames() {
		return duplicateNickNames;
	}

}
