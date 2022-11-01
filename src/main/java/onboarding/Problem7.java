package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * 기능 목록 1) frinedPoint 2) visitPoint 3) existFriend 4) suggestFriend
 * 
 * @version java 11 2022년 11월 1일
 * @author 이규호(tlqkrus012345)
 *
 */
public class Problem7 {

	static HashMap<String, Integer> point = new HashMap<>();
	static List<String> userFriend = new ArrayList<>();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = new ArrayList<>();

		existFriend(user, friends);
		visitPoint(visitors);

		return answer;
	}

	/**
	 * user와 기존에 친구인 userFriend 배열을 만드는 기능이다
	 * 
	 * @param user
	 * @param friends
	 */
	public static void existFriend(String user, List<List<String>> friends) {
		for (List<String> list : friends) {
			if (list.get(0).equals(user)) {
				userFriend.add(list.get(1));
			}
			if (list.get(1).equals(user)) {
				userFriend.add(list.get(0));
			}
		}
	}

	/**
	 * 방문한 친구들 visitors배열 기준으로 +1점씩 point map에 집어넣는 기능이다
	 * 
	 * @param visitors
	 */
	public static void visitPoint(List<String> visitors) {
		for(String user : visitors) {
			point.put(user, point.getOrDefault(user, 0)+1);
		}
	}
}
