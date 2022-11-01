package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        List<Character> chars = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();

        for (char c : cryptogram.toCharArray())
            chars.add(c);

        while (true) {
            for (int i = 0; i < chars.size() - 1; i++) {
                if (chars.get(i) == chars.get(i + 1))
                    indices.add(i);
            }

            if (indices.size() == 0)
                break;

            for (Integer i : indices) {
                chars.remove(i - 2 * indices.indexOf(i));
                chars.remove(i - 2 * indices.indexOf(i));
            }
            indices.clear();
        }

        for (Character c : chars)
            answer += c;

        return answer;
    }
}
