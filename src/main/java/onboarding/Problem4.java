package onboarding;

import java.util.HashMap;

/**
 * 기능 목록 1) makeGraph 2) frog
 * 
 * @version java 11 2022년 10월 31일
 * @author 이규호(tlqkrus012345)
 *
 */
public class Problem4 {

	static String answer = "";
	static HashMap<Integer, Integer> graph;

	public static String solution(String word) {
		makeGraph();

		return answer;
	}

	/**
	 * 청개구리표를 만드는 기능이다. A:65 ~ Z:90, a:97 ~ z:122 까지 HashMap에 넣는다 마지막으로 공백 32도 넣는다.
	 */
	public static void makeGraph() {
		graph = new HashMap<>();
		int upperZ = 90;
		int lowerZ = 122;

		for (int i = 65; i <= 90; i++) {
			graph.put(i, upperZ);
			upperZ--;
		}

		for (int i = 97; i <= 122; i++) {
			graph.put(i, lowerZ);
			lowerZ--;
		}

		graph.put(32, 32);
	}
}
