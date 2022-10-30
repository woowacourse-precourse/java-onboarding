package onboarding;

import java.util.List;
import java.util.Comparator;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

	private static boolean compare(String name1, String name2) {
		if(name1.length() == 1 || name2.length() == 1)
			return false;

		for(int i = 0;i < name1.length() - 1;i++) {
			for(int j = 0;j < name2.length() - 1;j++) {
				if(name1.substring(i,i + 2).equals(name2.substring(j,j + 2)))
					return true;
			}
		}

		return false;
	}
}
