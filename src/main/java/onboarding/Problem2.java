package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> word = new ArrayDeque<>();

        for(Character e: cryptogram.toCharArray())
        {
            if(!word.isEmpty() && word.peekLast() == e) { word.pollLast(); continue; }
            word.addLast(e);
        }

        for(Character e: word) sb.append(e);


        return sb.toString();

    }
}
