package onboarding;

import java.util.*;

public class Problem7 {
	public static class Point{
		String name;
		int point;
		public Point(String name, int point) {
			this.name = name;
			this.point = point;
		}
	}

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

		List<String> answer = Collections.emptyList();

		List<String> userFriendsList = new ArrayList<>(); // 유저가 포함된 친구 목록(유저를 제외한)
		List<List<String>> otherFriendsList = new ArrayList<>();// 유저가 포함되어 있지 않는 친구 목록 (쌍)

		// 추천 친구 목록들이 저장 되어있는 리스트
		List<String> friendsRecommendList = new ArrayList<>();
		List<String> visitorRecommendList = new ArrayList<>();

		// 두 리스트를 포함한 HashMap
		HashMap<String, Integer> point = new HashMap<>();


		// 유저의 친구 목록 구하기, user = "mrko"
		for (List<String> existedFriendList : friends) {
			if (existedFriendList.contains(user)) {
				userFriendsList.add(exceptUser(existedFriendList, user)); //["donut", "shakevan"]
			} else {
				otherFriendsList.add(
					existedFriendList);//[ ["donut", "andole"], ["donut", "jun"], ["shakevan", "andole"], ["shakevan", "jun"] ]
			}
		}
		for (String userFriend : userFriendsList) { // ["donut", "shakevan"]
			for (List<String> otherFriendsPair : otherFriendsList) { //[ ["donut", "andole"], ["donut", "jun"], ["shakevan", "andole"], ["shakevan", "jun"] ]
				if (otherFriendsPair.contains(userFriend)) {
					friendsRecommendList.add(
						exceptUser(otherFriendsPair, userFriend)); // ["andole", "jun", "andole", "jun"]
				}
			}
		}

		for (int i = 0; i < visitors.size(); i++) {
			String visitor = visitors.get(i);
			if (!visitor.equals(user) && !userFriendsList.contains(visitor)) {
				visitorRecommendList.add(visitor); // ["bedi", "bedi", "bedi"]
			}
		}


		for(int i = 0 ; i < friendsRecommendList.size() ; i++){
			if(point.containsKey(friendsRecommendList.get(i))){
				point.put(friendsRecommendList.get(i), point.get(friendsRecommendList.get(i)) + 10);
				continue;
			}

			point.put(friendsRecommendList.get(i), 10);
		}

		for(int i = 0 ; i < visitorRecommendList.size() ; i++){
			if(point.containsKey(visitorRecommendList.get(i))){
				point.put(visitorRecommendList.get(i), point.get(visitorRecommendList.get(i)) + 1);
				continue;
			}

			point.put(visitorRecommendList.get(i), 1);
		}


		//그다음 이제 정렬만 해주면 됨
		answer = sortPointAndName(point);

		return answer;
	}

	public static List<String> sortPointAndName(HashMap<String, Integer> point){

		List<Point> pointList = new ArrayList<>();  //hashmap은 순서가 없기에 정렬를 쉽게 하지 못하기때문에 변경
		List<String> result = new ArrayList<>();
		for(String key : point.keySet()){
			Point newPoint = new Point(key, point.get(key));
			pointList.add(newPoint);
		}

		Collections.sort(pointList, new Comparator<Point>() {   //point먼저 그후 name 정렬
			@Override
			public int compare(Point o1, Point o2) {

				if(o1.point < o2.point) return 1;
				else if(o1.point > o2.point) return -1;
				else{
					return o1.name.compareTo(o2.name);
				}
			}
		});

		for(Point t : pointList){
			if(t.point > 0){
				result.add(t.name);
			}
		}

		return result;
	}

	// 리스트 중 유저를 포함하고 있지만, 유저가 아닌 이름 뽑는 메소드
	private static String exceptUser(List<String> findList, String name) {
		if (findList.get(0).equals(name)) {
			return findList.get(1);
		} else {
			return findList.get(0);
		}
	}

}