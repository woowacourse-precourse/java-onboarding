package onboarding.problem2;

import java.util.LinkedList;
import java.util.Queue;

public class Decoder {

    private final Queue<Character> decodingText = new LinkedList<>();

    public Decoder(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++)
            decodingText.add(cryptogram.charAt(i));
    }

    public String decode() {
        int size;
        do {
            size = decodingText.size();
            removeDuplication(size);
        } while (size != decodingText.size() && !decodingText.isEmpty());
        return buildPlainText();
    }

    private void removeDuplication(int size) {
        boolean duplicated = false;

        for (int i = 0; i < size - 1; i++) {
            Character ch = decodingText.poll();
            if (decodingText.peek() == ch)
                duplicated = true;
            else if (duplicated)
                duplicated = false;
            else
                decodingText.add(ch);
        }

        if (duplicated)
            decodingText.poll();
        else
            decodingText.add(decodingText.poll());
    }

    private String buildPlainText() {
        StringBuilder plainBuilder = new StringBuilder();
        while (!decodingText.isEmpty())
            plainBuilder.append(decodingText.poll());
        return plainBuilder.toString();
    }
}
