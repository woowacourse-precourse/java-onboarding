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
	private static List<String> getVisitorsWithoutMyFriends(List<String> visitors,List<String> myFriends){
		List<String> visitorsWithoutMyFriends = new ArrayList<String>();
		for(int i=0;i<visitors.size();i++) {
			boolean flag = true;
			for(String myFriend : myFriends) {
				if(visitors.get(i).contains(myFriend)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				visitorsWithoutMyFriends.add(visitors.get(i));
			}
		}
		return visitorsWithoutMyFriends;
	}
	private static Map<String,Integer> getFriendScore
	(List<String> friendForRecommand,List<String> visitors){
		Map<String,Integer> friendScore = countFriend(friendForRecommand);
		Map<String,Integer> visitorScore = countVisitor(visitors);
		
		for(String visitor : visitorScore.keySet()) {
			friendScore.merge(visitor, visitorScore.get(visitor), Integer :: sum);
		}
		return friendScore;
	}
	private static Map<String,Integer> countFriend(List<String> friendForRecommand){
		Map<String,Integer> friendScore = new TreeMap<String,Integer>();
		for(String friend : friendForRecommand) {
			
			if(friendScore.get(friend) != null)
				friendScore.put(friend, friendScore.get(friend)+10);
			
			if(friendScore.get(friend) == null)
				friendScore.put(friend, 10);
		}
		return friendScore;
	}
	private static Map<String,Integer> countVisitor(List<String> visitors){
		Map<String,Integer> friendScore = new TreeMap<String,Integer>();
		for(String vistor : visitors) {
			
			if(friendScore.get(vistor) != null)
				friendScore.put(vistor, friendScore.get(vistor)+1);
			
			if(friendScore.get(vistor) == null)
				friendScore.put(vistor, 1);
		}
		return friendScore;
	}
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        //"이미 친구"
        List<String> alreadyFriends = getAlreadyFriends(user,friends);

		//"나를 제외한 친구관계"
		List<List<String>> friendsWithoutUser = getFriendsWithoutUser(user, friends);
		
		//"추천할 친구"
		List<String> friendForRecommands =getFriendForRecommand(alreadyFriends, friendsWithoutUser);
		
		//"친구를 제외한 방문자 목록"
		List<String> visitorsWithoutMyFriends = getVisitorsWithoutMyFriends(visitors, alreadyFriends);
		
		//"추천 예정 친구,점수"
		Map<String,Integer> friendScore = getFriendScore(friendForRecommands, visitorsWithoutMyFriends);
		
		
		
        return answer;
    }
}
