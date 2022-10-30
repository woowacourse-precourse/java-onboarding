package onboarding;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.stream.Collectors;


public class Problem2 {
	public static String solution(String cryptogram) {

		Deque<Character> decryptionQueue = getCharacterQueueByString(cryptogram);

		while (true) {
			decrypt(decryptionQueue);
		}


		return covertCharacterCollectionToString(decryptionQueue);
	}

	private static Deque<Character> getCharacterQueueByString(String string) {
		Deque<Character> queue = new ArrayDeque<>();
		for (char character : string.toCharArray()) {
			queue.offer(character);
		}


		return queue;
	}

	private static String covertCharacterCollectionToString(Collection<Character> collection) {
		return collection.stream()
			.map(String::valueOf)
			.collect(Collectors.joining());
	}
}
