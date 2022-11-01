package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Problem2 {

	public static String solution(String cryptogram) {
		try {
			validate(cryptogram);
			String answer;
			String prev = removeDuplication(cryptogram);
			String next;
			while (true) {
				next = removeDuplication(prev);
				if (next.equals(prev)) {
					answer = next;
					break;
				}
				prev = next;
			}
			return answer;
		} catch (Exception e) {
			System.out.println(e);
			return "Wrong input";
		}
	}

	static String removeDuplication(String cryptogram) {
		List<String> inputList = new ArrayList<>(Arrays.asList(cryptogram.split("")));
		Set<Integer> duplicationIndexSet = getDuplicationIndexSet(inputList);
		List<String> outputList = removeDuplicationBySet(inputList,
			duplicationIndexSet);
		String answer = joinStringWithoutNull(outputList);
		return answer;
	}

	static Set<Integer> getDuplicationIndexSet(List<String> inputArrayList) {
		Set<Integer> duplicationSet = new HashSet<>();
		for (int i = 0; i < inputArrayList.size() - 1; i++) {
			String pre = inputArrayList.get(i);
			String next = inputArrayList.get(i + 1);
			if (pre.equals(next)) {
				duplicationSet.add(i);
				duplicationSet.add(i + 1);
			}
		}
		return duplicationSet;
	}

	static List<String> removeDuplicationBySet(
		List<String> stringList,
		Set<Integer> duplicationSet
	) {
		for (int i = 0; i < stringList.size(); i++) {
			if (duplicationSet.contains(i)) {
				stringList.remove(i);
				stringList.add(i, null);
			}
		}
		return stringList;
	}

	static String joinStringWithoutNull(List<String> stringList) {
		String result = "";
		for (int i = 0; i < stringList.size(); i++) {
			String str = stringList.get(i);
			if (str != null) {
				result += str;
			}
		}
		return result;
	}

	static void validate(String cryptogram) throws Exception {
		String pattern = "^[a-z]{1,1000}$";
		boolean isMatch = Pattern.matches(pattern, cryptogram);
		if (!isMatch) {
			throw new Exception("입력이 잘못되었습니다");
		}
	}
}
