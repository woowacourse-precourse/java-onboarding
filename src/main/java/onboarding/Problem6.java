package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

		List<String> limitList = new ArrayList<>();
		for (List<String> form : forms) {
			for (int nameIndex = 0; nameIndex < form.get(1).length() - 1; nameIndex++) {
				String duplicatedName = form.get(1).substring(nameIndex, nameIndex + 2);
				if (duplicatedNameCount.get(duplicatedName) > 1) {
					limitList.add(form.get(0));
					continue;
				}
			}
		}
		
		return limitList.stream()
			.distinct()
			.sorted()
			.collect(Collectors.toList());
	}
}
