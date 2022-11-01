package onboarding;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.stream.Collectors;

public class Problem2 {
	public static String solution(String cryptogram) {
		Deque<Character> decryptionQueue = getCharacterQueueByString(cryptogram);
		int beforeSize;

		do {
			beforeSize = decryptionQueue.size();
			decryptionQueue = removeSerialChar(decryptionQueue);
		} while (!isDecrypted(decryptionQueue, beforeSize));

		return covertCharacterCollectionToString(decryptionQueue);
	}

	private static boolean isDecrypted(Deque<Character> decryptionQueue, int beforeSize) {
		return beforeSize == decryptionQueue.size();
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
			moveCharacterTo(decryptionQueue, tmpQueue);
		}

		return tmpQueue;
	}

	private static void moveCharacterTo(Deque<Character> decryptionQueue, Deque<Character> tmpQueue) {
		Character c = decryptionQueue.poll();
		if (tmpQueue.isEmpty()) {
			tmpQueue.offerLast(c);
			return;
		}

		if (tmpQueue.peekLast() == c) {
			skipDuplicatedCharacter(decryptionQueue, tmpQueue);
			return;
		}

		tmpQueue.offerLast(c);
	}

	private static void skipDuplicatedCharacter(Deque<Character> decryptionQueue, Deque<Character> tmpQueue) {
		while (tmpQueue.peekLast() == decryptionQueue.peekFirst()) {
			decryptionQueue.poll();
		}
		tmpQueue.pollLast();

		if (!decryptionQueue.isEmpty()) {
			tmpQueue.offerLast(decryptionQueue.poll());
		}
	}

	private static String covertCharacterCollectionToString(Collection<Character> collection) {
		return collection.stream()
			.map(String::valueOf)
			.collect(Collectors.joining());
	}
}
