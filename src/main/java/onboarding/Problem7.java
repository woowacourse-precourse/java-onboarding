package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Problem7 {

	public static List<String> friend = new ArrayList<>(); // 친구 리스트
	public static Map<String, Integer> recommand = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

    	List<String> answer = new ArrayList<>();

		friend_list(user, friends);

		// 추천하는 친구(방문객)
		for(int i = 0; i < visitors.size(); i++) {
			String visit = visitors.get(i);
			 if(id_exception(visit, user)) continue;
			// 추천인에 존재하지 않으면 추가, 있으면 +1씩 덧셈
			if(!recommand.containsKey(visit)) recommand.put(visit, 1);
			else {
				for(Entry<String, Integer> item : recommand.entrySet()) {
					if(item.getKey().equals(visit)) item.setValue(item.getValue() + 1);
				}
			}
		}

		// 추천하는 친구(친구의 친구)
		for(int i = 0; i < friend.size(); i++) {
			String f = friend.get(i);

			for(int j = 0; j < friends.size(); j++) {
				List<String> friend_list = friends.get(j);
				if(friend_list.get(0).equals(f)) {
					if(id_exception(friend_list.get(1), user)) continue;
					if(!recommand.containsKey(friend_list.get(1))) recommand.put(friend_list.get(1), 10);
					else {
						for(Entry<String, Integer> item : recommand.entrySet()) {
							if(item.getKey().equals(friend_list.get(1))) item.setValue(item.getValue() + 10);
						}
					}
				}
				else if(friend_list.get(1).equals(f)) {
					if(id_exception(friend_list.get(0), user)) continue;
					if(!recommand.containsKey(friend_list.get(0))) recommand.put(friend_list.get(0), 10);
					else {
						for(Entry<String, Integer> item : recommand.entrySet()) {
							if(item.getKey().equals(friend_list.get(0))) item.setValue(item.getValue() + 10);
						}
					}
				}
			}
		}

		// System.out.println(recommand);

		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(recommand.entrySet());
		entryList.sort((o1, o2) -> {
			if(o1.getValue() == o2.getValue()) {
				return o1.getKey().compareTo(o2.getKey()); // 키의 이름순 정렬
			} else {
				return o2.getValue() - o1.getValue(); // 값의 내림차순
			}
		});

		// System.out.println(entryList);

		for(int i = 0; i < entryList.size(); i++) {
			answer.add(entryList.get(i).getKey());
		}

        return answer;
    }


	// 현재 친구 리스트
	public static void friend_list(String user, List<List<String>> friends) {
		for(int i = 0; i < friends.size(); i++) {
			List<String> friend_list = friends.get(i);
			if(friend_list.get(0).equals(user)) friend.add(friend_list.get(1));
			else if(friend_list.get(1).equals(user)) friend.add(friend_list.get(0));
		}
	}

	// 체크하는 아이디에서 친구이거나 본인인 경우 예외처리
	public static boolean id_exception(String chk_id, String user) {

		// 본인 체크
		if(chk_id.equals(user)) return true;

		// 친구 목록 체크
		if(friend.contains(chk_id)) return true;

		return false;
	}
}