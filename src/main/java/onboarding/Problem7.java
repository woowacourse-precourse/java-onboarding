package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();

		AlgorithmSource algorithmSource = new AlgorithmSource(user, friends, visitors);
		answer = algorithmSource.getRecommendedFriends();

		return answer;
	}

}

class AlgorithmSource {
	private String user; 	/* 대상 사용자 */
	private List<List<String>> friends;	/* 친구 리스트 */
	private List<String> visitors;	/* 방문기록 */
	private List<String> otherUserList; /* 대상 사용자를 제외한 모든 사용자 */
	
	
	/**
     * AlgorithmSource 생성자
     * 인스턴스 변수 값을 설정하고 모든 유저 리스트를 셋팅한다.
     * @param 사용자 아이디 user , 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors
     */
	public AlgorithmSource(String user, List<List<String>> friends, List<String> visitors) {
		super();
		this.user = user;
		this.friends = friends;
		this.visitors = visitors;
		
		setOtherUserList();
	}

	/**
     * 대상 사용자를 제외한 모든 유저 리스트를 셋팅한다.
     */
	private void setOtherUserList() {
		Set<String> userList = new HashSet<String>();
		
		for (List<String> friend : friends) {
			String user1 = friend.get(0);
			String user2 = friend.get(1);
			userList.add(user1);
			userList.add(user2);
		}
		userList.addAll(visitors);
		userList.remove(user);
		
		this.otherUserList = new ArrayList<>(userList);
	}

	/**
     * 추천친구 목록 탑3를 만든다
     * @return 추천친구 목록 탑3
     */
	public List<String> getRecommendedFriends() {

		List<String> usersFriendList = getFriendList(user);
		Map<String, Integer> otherUserAndScore = new HashMap<String, Integer>();
		
		for(String otherUser :  otherUserList) {
			List<String> otherUserFriendList  = getFriendList(otherUser);
			int otherUserScore = 0;
			otherUserScore = compareFriendList(usersFriendList, otherUserFriendList);
			otherUserScore += countVisit(otherUser);
			if(otherUserScore != 0) {
				otherUserAndScore.put(otherUser, otherUserScore);
			}
		}
		
		List<String> recommendedFriends = sortOtherUserAndScore(otherUserAndScore);
		
		return recommendedFriends;
	}

	
	/**
     * 서로의 친구목록을 비교하여 겹치는 친구가 있는지 확인한다.
     * @param user1의 친구목록, user2의 친구목록 
     * @return 겹치는 친구의 수*10
     */
	private int compareFriendList(List<String> usersFriendList, List<String> otherUserFriendList) {
		int otherUserScore = 0;
		for(String friend : usersFriendList) {
			if(otherUserFriendList.indexOf(friend) != -1) {
				otherUserScore += 10;
			}
		}
		
		return otherUserScore;
	}
	
	/**
     * 해당 user가 나에게 몇번 방문했는지 확인한다.
     * @param 해당 user
     * @return 방문횟수
     */
	private int countVisit(String otherUser) {
		
		int otherUserScore = 0;
		
		for(String visitor : visitors) {
			if(visitor.equals(otherUser)) {
				otherUserScore++;
			}
		}
		
		return otherUserScore;
	}

	/**
     * 해당 user의 친구목록을 반환한다.
     * @param 해당 user
     * @return 친구목록
     */
	private List<String> getFriendList(String targetUser) {
		List<String> usersFriendList = new ArrayList<String>();

		for (List<String> friend : friends) {
			String user1 = friend.get(0);
			String user2 = friend.get(1);
			if(user1.equals(targetUser)) {
				usersFriendList.add(user2);
			}
			if(user2.equals(targetUser)){
				usersFriendList.add(user1);
			}
		}
		return usersFriendList;
	}

	/**
     * user의 점수를 확인하고 정렬하여 추천친구 목록을 반환한다.
     * @param <user,점수>가 담긴 Map
     * @return 추천 친구목록
     */
	private List<String> sortOtherUserAndScore(Map<String, Integer> otherUserAndScore) {
		
		System.out.println(otherUserAndScore);
		Comparator<String> scoreSort = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				return otherUserAndScore.get(o2) - otherUserAndScore.get(o1);
			}
		};
		otherUserList.sort(scoreSort);
		return otherUserList.subList(0, 3);
	}


}
