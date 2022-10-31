package onboarding.problem2;

import java.util.LinkedList;
import java.util.Queue;

public class Decoder {

    private final Queue<Character> text = new LinkedList<>();

    public Decoder(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++)
            text.add(cryptogram.charAt(i));
    }

    public String decode() {
        int size;
        do {
            size = text.size();
            removeDuplication(size);
        } while (size != text.size() && !text.isEmpty());
        return buildPlainText();
    }

    private void removeDuplication(int size) {
        boolean duplicated = false;

        for (int i = 0; i < size - 1; i++) {
            Character ch = text.poll();
            if (text.peek() == ch)
                duplicated = true;
            else if (duplicated)
                duplicated = false;
            else
                text.add(ch);
        }

        if (duplicated)
            text.poll();
        else
            text.add(text.poll());
    }

    private String buildPlainText() {
        StringBuilder plainBuilder = new StringBuilder();
        while (!text.isEmpty())
            plainBuilder.append(text.poll());
        return plainBuilder.toString();
    }
}
