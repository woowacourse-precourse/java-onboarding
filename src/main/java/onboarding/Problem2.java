package onboarding;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.Collectors;

public class Problem2 {
	public static String solution(String cryptogram) {
		Deque<Character> decryptionQueue = getCharacterQueueByString(cryptogram);
		int beforeSize;

		do {
			beforeSize = decryptionQueue.size();
			decryptionQueue = removeSerialChar(decryptionQueue);
		} while (beforeSize != decryptionQueue.size());

		return covertCharacterCollectionToString(decryptionQueue);
	}

	private static Deque<Character> getCharacterQueueByString(String string) {
		Deque<Character> queue = new ArrayDeque<>();
		for (char character : string.toCharArray()) {
			queue.offer(character);
		}

		return queue;
	}

	private static Deque<Character> removeSerialChar(Deque<Character> decryptionQueue) {
		Deque<Character> tmpQueue = new ArrayDeque<>();

		while (!decryptionQueue.isEmpty()) {
			Character c = decryptionQueue.poll();
			if (tmpQueue.isEmpty()) {
				tmpQueue.offerLast(c);
				continue;
			}

			if (tmpQueue.peekLast() == c) {
				while (tmpQueue.peekLast() == decryptionQueue.peekFirst()) {
					decryptionQueue.poll();
				}
				tmpQueue.pollLast();
				if (!decryptionQueue.isEmpty()) {
					tmpQueue.offerLast(decryptionQueue.poll());
				}
				continue;
			}

			tmpQueue.offerLast(c);
		}

		return tmpQueue;
	}

	private static String covertCharacterCollectionToString(Collection<Character> collection) {
		return collection.stream()
			.map(String::valueOf)
			.collect(Collectors.joining());
	}
}
