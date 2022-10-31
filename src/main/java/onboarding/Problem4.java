package onboarding;

import java.util.LinkedList;
import java.util.Queue;

public class Problem4 {

	public static Queue<Character>queue = new LinkedList<>();

	public static String solution(String word) {
		String answer = "";

		queue = wordCheck(word);

		return answer;
	}

	public static Queue<Character> wordCheck(String word) {

		for(int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			int distance = 0;

			if(65 <= character && character <= 90) {
				distance = 90 - character;
				character = (char) (65 + distance);
			} else if(97 <= character && character <= 122) {
				distance = 122 - character;
				character = (char) (97 + distance);
			}

			queue.offer(character);
		}

		return queue;
	}

}
