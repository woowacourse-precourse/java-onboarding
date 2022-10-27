package problem2;

import java.util.*;

public class CipherTextDecoder {

    public List<Character> parseToAlphabetList(String word) {
        List<Character> alphabets = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            alphabets.add(word.charAt(i));
        }
        return alphabets;
    }

    public String decode(String word) {
        List<Character> alphabets = parseToAlphabetList(word);
        Deque<Character> stack = new ArrayDeque<>();

        for (Character alphabet : alphabets) {
            if (stack.isEmpty()) {
                stack.offerLast(alphabet);
                continue;
            }
            putAlphabetIsNotEmpty(stack, alphabet);
        }

        return mapToString(stack);
    }

    private void putAlphabetIsNotEmpty(Deque<Character> stack, Character alphabet) {
        if (!stack.isEmpty()) {
            removeOrAdd(stack, alphabet);
        }
    }

    private void removeOrAdd(Deque<Character> stack, Character alphabet) {
        Character peek = stack.peekLast();
        if (peek.equals(alphabet)) {
            stack.pollLast();
        }
        if (!peek.equals(alphabet)) {
            stack.offerLast(alphabet);
        }
    }

    private String mapToString(Deque<Character> stack) {
        StringBuilder sb = new StringBuilder();

        stack.stream().forEach(c -> sb.append(c));
        return sb.toString();
    }
}
