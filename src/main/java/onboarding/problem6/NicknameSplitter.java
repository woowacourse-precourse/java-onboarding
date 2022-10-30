package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class NicknameSplitter {

	public static final int START_NUMBer = 1;

	public List<String> split(String nickName) {
		List<String> repetitionList = new ArrayList<>();
		int start = START_NUMBer;
		while (start < nickName.length()) {
			repetitionList.add(nickName.substring(start - 1, start + 1));
			start++;
		}
		return repetitionList;
	}
}
