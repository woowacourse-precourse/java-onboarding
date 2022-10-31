package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        //"이미 친구"
        List<String> alreadyFriends = getAlreadyFriends(user,friends);

		//"나를 제외한 친구관계"
		List<List<String>> friendsWithoutUser = getFriendsWithoutUser(user, friends);
		
		
        return answer;
    }
}
