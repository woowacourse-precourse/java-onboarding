package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

		List<String> userfriends = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		List<String> answer = new ArrayList<>();
		for (List<String> list : friends) {
			String friend1 = list.get(0), friend2 = list.get(1);
			if (friend1 == user) {
				userfriends.add(friend2);
			}
			if (friend2 == user) {
				userfriends.add(friend1);
			}
		}

	}


}