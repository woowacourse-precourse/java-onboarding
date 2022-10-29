package onboarding.problemseven.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sns {

	private HashMap<String,List<String>> friendMap = new HashMap<>();

	public Sns(List<List<String>> friends) {
		for(List<String> friend:friends){
			String userA=friend.get(0);
			String userB=friend.get(1);

			addFriend(userA,userB);
			addFriend(userB,userA);
		}
	}

	private void addFriend(String userA, String userB) {
		if(friendMap.containsKey(userA)){
			friendMap.get(userA).add(userB);
		} else if (!friendMap.containsKey(userA)) {
			List<String> friendList = new ArrayList<>();
			friendList.add(userB);
			friendMap.put(userA,friendList);
		}
	}
}
