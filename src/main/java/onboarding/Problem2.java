package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        LinkedList<Character> characters = new LinkedList<>();
        characters.add(cryptogram.charAt(0));
        for (int i = 1; i < cryptogram.length(); i++) {
            Character prev = cryptogram.charAt(i-1);
            Character curr = cryptogram.charAt(i);
            Character last = characters.peekLast();
            updateLinkedList(prev, curr, last, characters);
        }
        return linkedlistToString(characters);
    }

    private static void updateLinkedList(Character prev,
                                         Character curr,
                                         Character last,
                                         LinkedList<Character> chars) {
        if (!curr.equals(prev) && !curr.equals(last)) {
            chars.add(curr);
        } else if (curr.equals(last)) {
            chars.removeLast();
        }
    }

    private static String linkedlistToString(LinkedList<Character> chars) {
        StringBuilder sb = new StringBuilder();
        chars.forEach(item -> {
            sb.append(item);
        });
        return sb.toString();
    }
}

