package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class NicknameSplitter {

	public static final int START_NUMBER = 1;

	public List<String> split(String nickName) {
		List<String> repetitionList = new ArrayList<>();
		int start = START_NUMBER;
		while (start < nickName.length()) {
			repetitionList.add(nickName.substring(start - 1, start + 1));
			start++;
		}
		return repetitionList;
	}
}
