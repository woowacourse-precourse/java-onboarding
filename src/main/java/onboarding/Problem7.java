package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = new ArrayList<>();

		Map<String, Integer> score = new HashMap<>();

		Map<String, List<String>> fMap = getFriendsMap(friends);

		Set<Map.Entry<String, List<String>>> entrySet = fMap.entrySet();
		Iterator<Map.Entry<String, List<String>>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Map.Entry<String, List<String>> entry = entryIterator.next();
			String key = entry.getKey();
			List<String> list = entry.getValue();

			if (list.contains(user)) {
				for (String person : list) {
					if (!fMap.get(user).contains(person) && person != user) {
						if (score.containsKey(person)) {
							Integer val = score.get(person);
							val += 5;
							score.put(person, val);
						} else {
							score.put(person, 5);
						}
					}
				}
			}

		}

		for (String visitor : visitors) {
			if (!fMap.get(user).contains(visitor)) {
				if (score.containsKey(visitor)) {
					Integer val = score.get(visitor);
					val += 1;
					score.put(visitor, val);
				} else {
					score.put(visitor, 1);
				}
			}
		}

		List<Entry<String, Integer>> listEntry = new ArrayList<Entry<String, Integer>>(score.entrySet());
		listEntry = conditionalSortList(listEntry);
		for (Entry<String, Integer> entry : listEntry) {
			answer.add(entry.getKey());

		}

		return answer;
	}

	static Map<String, List<String>> getFriendsMap(List<List<String>> friends) {

		Map<String, List<String>> fMap = new HashMap<>();

		for (List<String> friend : friends) {

			String friend1 = friend.get(0);
			String friend2 = friend.get(1);

			if (fMap.containsKey(friend1)) {
				List<String> fList = fMap.get(friend1);
				fList.add(friend2);
			} else {
				List<String> fList = new ArrayList<>();
				fList.add(friend2);
				fMap.put(friend1, fList);

			}

			if (fMap.containsKey(friend2)) {
				List<String> fList = fMap.get(friend2);
				fList.add(friend1);
			} else {
				List<String> fList = new ArrayList<>();
				fList.add(friend1);
				fMap.put(friend2, fList);
			}

		}

		return fMap;
	}
	
	static List<Entry<String, Integer>> conditionalSortList(List<Entry<String, Integer>> listEntry){
		Collections.sort(listEntry, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				int ret = 0;
				if (obj1.getValue() < obj2.getValue()) {
					ret = 1;
				} else if (obj1.getValue() == obj2.getValue()) {
					if (obj1.getKey().compareTo(obj2.getKey()) < 0) {
						ret = -1;
					} else if (obj1.getKey().compareTo(obj2.getKey()) == 0) {
						ret = 0;
					} else if (obj1.getKey().compareTo(obj2.getKey()) > 0) {
						ret = 1;
					}

				} else if (obj1.getValue() > obj2.getValue()) {
					ret = -1;
				}
				return ret;
			}
		});

		return listEntry;
	}	
}
