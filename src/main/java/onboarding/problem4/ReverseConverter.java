package onboarding.problem4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseConverter {
	public static final List<Character> dict = IntStream.rangeClosed('A', 'Z')
		.mapToObj(c -> (char)c)
		.collect(Collectors.toList());
	public static final List<Character> reverseDict = dict.stream()
		.sorted(Comparator.reverseOrder())
		.collect(Collectors.toList());

	public static Character convert(Character character) {
		if (Character.isUpperCase(character)) {
			return reverseDict.get(dict.indexOf(character));
		} else {
			int index = dict.indexOf(Character.toUpperCase(character));
			return Character.toLowerCase(reverseDict.get(index));
		}
	}

	public static String convert(String word) {
		StringBuilder result = new StringBuilder();
		for (char c : word.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				result.append(convert(c));
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}
}
