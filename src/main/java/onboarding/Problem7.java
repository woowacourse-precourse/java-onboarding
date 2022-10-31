package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Problem7 {
	private static List<String> getAlreadyFriends
	(String user,List<List<String>> friends){
		List<String> alreadyFriendList = new ArrayList<String>();
		String myFriend = "";
		for(List<String> friendList : friends) {
			if(friendList.contains(user)) {
				myFriend = getUsersFriend(user, friendList);
				alreadyFriendList.add(myFriend);
			}
		}
		return alreadyFriendList;
	}
	private static String getUsersFriend
	(String user,List<String> friendList) {
		String returnId= "";
		for(String id : friendList) {
			if(id != user) {
				returnId = id;
				return returnId;
			}
		}
		return returnId;
	}
	private static List<List<String>> getFriendsWithoutUser
	(String user,List<List<String>> friends){
		List<List<String>> friendsWithoutUser = new ArrayList<List<String>>();

		for(int i=0;i<friends.size();i++) {
			if(!friends.get(i).contains(user)) {
				friendsWithoutUser.add(friends.get(i));
			}
		}

		return friendsWithoutUser;
	}
	private static List<String> getFriendForRecommand
	(List<String> alreadyFriends,List<List<String>> friendsWithoutUser){
		List<String> friendForRecommands = new ArrayList<String>();
		String friendForRecommand = "";
		for(String myFriend : alreadyFriends) {
			for(List<String> friendList : friendsWithoutUser) {
				if(friendList.contains(myFriend)) {
					friendForRecommand = getUsersFriend(myFriend, friendList);
					friendForRecommands.add(friendForRecommand);
				}
			}
		}
		return friendForRecommands;
	}
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        //"이미 친구"
        List<String> alreadyFriends = getAlreadyFriends(user,friends);

		//"나를 제외한 친구관계"
		List<List<String>> friendsWithoutUser = getFriendsWithoutUser(user, friends);
		
		//"추천할 친구"
		List<String> friendForRecommands =getFriendForRecommand(alreadyFriends, friendsWithoutUser);
		
		
        return answer;
    }
}
