package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		Map<String, Integer> duplicatedNameCount = new HashMap<>();
		for (List<String> form : forms) {
			for (int nameIndex = 0; nameIndex < form.get(1).length() - 1; nameIndex++) {
				String duplicatedName = form.get(1).substring(nameIndex, nameIndex + 2);
				if (!duplicatedNameCount.containsKey(duplicatedName)) {
					duplicatedNameCount.put(duplicatedName, 1);
				} else {
					duplicatedNameCount.put(duplicatedName, duplicatedNameCount.get(duplicatedName) + 1);
				}
			}
		}
		return Collections.emptyList();
	}
}
