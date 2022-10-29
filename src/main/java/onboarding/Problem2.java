package onboarding;

import java.util.Deque;
import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {

        Deque<Character> deque = new LinkedList<>();

        for (char word : cryptogram.toCharArray()) {
            if (isDequeEmpty(deque)) {
                insertWord(deque, word);
                continue;
            }

            if (!isDuplicatedWord(deque, word)) {
                insertWord(deque, word);
            }
            else
                deleteDuplicatedWord(deque);
        }

        return printResult(deque);
    }

    public static boolean isDequeEmpty(Deque<Character> deque) {
        return deque.isEmpty();
    }

    public static void insertWord(Deque<Character> deque, Character word) {
        deque.offerLast(word);
    }

    public static boolean isDuplicatedWord(Deque<Character> deque, Character word) {
        return deque.peekLast() == word;
    }

    public static void deleteDuplicatedWord(Deque<Character> deque) {
        deque.pollLast();
    }

    public static String printResult(Deque<Character> deque) {
        String resultCryptogram = "";
        while (!isDequeEmpty(deque)) {
            resultCryptogram += deque.pollFirst();
        }
        return resultCryptogram;
    }
}
