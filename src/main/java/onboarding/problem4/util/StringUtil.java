package onboarding.problem4.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class StringUtil {
	private static Pattern alphabetUpperPattern = Pattern.compile("^[A-Z]*$");
	private static Pattern alphabetLowcasePattern = Pattern.compile("^[a-z]*$");

	private static Map<String, String> frogMapUppercase = initMapUppercase();
	private static Map<String, String> frogMapLowerCase = initMapLowercase();

	public static List<String> separatedString(String word) {
		return Arrays.asList(word.split(""));
	}

	private static Map<String, String> initMapUppercase() {
		Map<String, String> mapUppercase = new HashMap<>();
		int mapValue = 91;
		for (int i = 65; i <= 90 ; i++) { // A ~ Z
			String uppercaseKey = String.valueOf((char) i);
			String uppercaseValue = String.valueOf((char) --mapValue);
			mapUppercase.put(uppercaseKey, uppercaseValue);
		}
		return mapUppercase;
	}

	private static Map<String, String> initMapLowercase() {
		Map<String, String> mapLowercase = new HashMap<>();

		Iterator<String> iteratorKey = initMapUppercase().keySet().iterator();
		while (iteratorKey.hasNext()) {
			String uppercaseKey = iteratorKey.next();
			String lowercaseKey = uppercaseKey.toLowerCase();
			String lowercaseValue = frogMapUppercase.get(uppercaseKey).toLowerCase();
			mapLowercase.put(lowercaseKey, lowercaseValue);
		}

		return mapLowercase;
	}

	public static String frogMapSwapKeyVale(String alphabet) {
		if (alphabet.length() > 1) throw new IllegalArgumentException("매개변수는 1글자입니다.");
		if (alphabetUpperPattern.matcher(alphabet).find())  return frogMapUppercase.get(alphabet);
		if (alphabetLowcasePattern.matcher(alphabet).find())  return frogMapLowerCase.get(alphabet);

		return alphabet;
	}
}
