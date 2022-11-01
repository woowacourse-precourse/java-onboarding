package onboarding;

import java.util.*;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		// 친구의 친구 점수, 방문 점수, 친구의 친구의 기준이 되는 친구, 아예 남인 방문자 변수 설정
		HashMap<String, Integer> guys = new HashMap<>();
		int fofVal = 0;
		int visitVal = 0;
		String temp = "";
		String fof = "";
		String visitor = "";

		for (int i = 0; i < friends.size(); i++) {
			List<String> friend = new ArrayList<>(friends.get(i));
			if (friend.get(0).equals(user)) {
				temp = friend.get(1); // temp -> 친구의 친구의 기준이 되는 친구
				for (int j = 0; j < friends.size(); j++) {
					if (friends.get(j).get(0).equals(temp)) {
						fofVal += 10;
						fof = friends.get(j).get(1); // fof -> 기준이 되는 친구의 친구
					} else if (friends.get(j).get(1).equals(temp)) {
						fofVal += 10;
						fof = friends.get(j).get(0);
					}
					guys.put(fof, fofVal);
				}
				for (int j = 0; j < visitors.size(); j++) { // 방문자 점수 설정
					if (!visitors.get(j).equals(fof)) {
						visitVal++;
						visitor = visitors.get(j);
					}
					guys.put(visitor, visitVal);
				}
			} else if (friend.get(1).equals(user)) {
				temp = friend.get(0);
				for (int j = 0; j < friends.size(); j++) {
					if (friends.get(j).get(0).equals(temp)) {
						fofVal += 10;
						fof = friends.get(j).get(1);
					} else if (friends.get(j).get(1).equals(temp)) {
						fofVal += 10;
						fof = friends.get(j).get(0);
					}
					guys.put(fof, fofVal);
				}
				for (int j = 0; j < visitors.size(); j++) {
					if (!visitors.get(j).equals(fof)) {
						visitVal++;
						visitor = visitors.get(j);
					}
					guys.put(visitor, visitVal);
				}
			}
			// 다시 볼 것
			guys.remove(temp);
			guys.remove(fof);
			guys.remove("donut");
		}

		List<String> result = new ArrayList<>(guys.keySet());

		return result;

	}
//	public static void main(String[] args) {
//		List<List<String>> friends = new ArrayList<>();
//		friends.add(0, List.of(new String[] {"donut", "andole"}));
//		friends.add(1, List.of(new String[] {"donut", "jun"}));
//		friends.add(2, List.of(new String[] {"donut", "mrko"}));
//		friends.add(3, List.of(new String[] {"shakevan", "andole"}));
//		friends.add(4, List.of(new String[] {"shakevan", "jun"}));
//		friends.add(5, List.of(new String[] {"shakevan", "mrko"}));
//		String user = "mrko";
//		List<String> visitors = new ArrayList<>();
//		visitors.add("bedi");
//		visitors.add("bedi");
//		visitors.add("donut");
//		visitors.add("bedi");
//		visitors.add("shakevan");
//		List<String> answer = new ArrayList<>();
//
//		HashSet<String> lists = new HashSet<>();
//		HashMap<String, Integer> guys = new HashMap<>();
//		int fofVal = 0;
//		int visitVal = 0;
//		String temp = "";
//		String fof = "";
//		String visitor = "";
//
//		for (int i = 0; i < friends.size(); i++) {
//			List<String> friend = new ArrayList<>(friends.get(i));
//			if (friend.get(0).equals(user)) {
//				temp = friend.get(1);
//				for (int j = 0; j < friends.size(); j++) {
//					if (friends.get(j).get(0).equals(temp)) {
//						fofVal += 10;
//						fof = friends.get(j).get(1);
//					} else if (friends.get(j).get(1).equals(temp)) {
//						fofVal += 10;
//						fof = friends.get(j).get(0);
//					}
//					guys.put(fof, fofVal);
//				}
//				for (int j = 0; j < visitors.size(); j++) {
//					if (!visitors.get(j).equals(fof)) {
//						visitVal++;
//						visitor = visitors.get(j);
//					}
//					guys.put(visitor, visitVal);
//				}
//			} else if (friend.get(1).equals(user)) {
//				temp = friend.get(0);
//				for (int j = 0; j < friends.size(); j++) {
//					if (friends.get(j).get(0).equals(temp)) {
//						fofVal += 10;
//						fof = friends.get(j).get(1);
//					} else if (friends.get(j).get(1).equals(temp)) {
//						fofVal += 10;
//						fof = friends.get(j).get(0);
//					}
//					guys.put(fof, fofVal);
//				}
//				for (int j = 0; j < visitors.size(); j++) {
//					if (!visitors.get(j).equals(fof)) {
//						visitVal++;
//						visitor = visitors.get(j);
//					}
//					guys.put(visitor, visitVal);
//				}
//			}
//			guys.remove(temp);
//			guys.remove(fof);
//			guys.remove("donut");
//		}
//
//		System.out.println(guys);
//
//		List<String> result = new ArrayList<>(guys.keySet());
//
//		System.out.println(result);
//	}
}
