package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = new ArrayList<>();
		HashMap<String, Integer> follow = new HashMap<String, Integer>();
		ArrayList<String> friend = new ArrayList<String>();
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).get(0).equals(user))
				friend.add(friends.get(i).get(1));
			if (friends.get(i).get(1).equals(user))
				friend.add(friends.get(i).get(0));
		}

		for (String f : friend) {
			for (int i = 0; i < friends.size(); i++) {
				if (friends.get(i).get(0).equals(f))
					follow.put(friends.get(i).get(1), follow.getOrDefault(f, 10) + 10);
				if (friends.get(i).get(1).equals(f))
					follow.put(friends.get(i).get(0), follow.getOrDefault(f, 10) + 10);
			}
		}
		follow.remove(user);

		for (String v : visitors) {
			if(friend.contains(v)) continue;
			follow.put(v, follow.getOrDefault(v, 1) + 1);
		}
		List<Integer> list = new ArrayList<>(follow.values());
		list.sort(Integer::compareTo);
		Arrays.sort(follow.keySet().toArray());
		
		Iterator<String> keys = follow.keySet().iterator();
		while(keys.hasNext()) {
			answer.add(keys.next());
		}
		return answer;
	}
}
