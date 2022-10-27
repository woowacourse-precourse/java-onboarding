package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    private static List<Character> chars;

    public static String solution(String cryptogram) {

        chars = getChars(cryptogram);

        removeDuplicates(chars);

        StringBuilder answer = new StringBuilder();
        for (Character c : chars)
            answer.append(c);

        return answer.toString();
    }

    /**
     * 2.1.1
     * 문자열에서 문자 리스트 get
     */
    public static List<Character> getChars(String word) {
        chars = new ArrayList<>();

        for (int i = 0; i < word.length(); i++)
            chars.add(word.charAt(i));

        return chars;
    }

    /**
     * 2.1.2
     * 문자 리스트에서 중복 문자 제거
     */
    public static void removeDuplicates(List<Character> characters) {
        int index = characters.size() - 1;

        while (index > 0) {
            if (characters.get(index-1) == characters.get(index)) {

                while (index > 0 && characters.get(index-1) == characters.get(index))
                    characters.remove(index--);

                characters.remove(index);
                index = characters.size() - 1;
                continue;
            }
            index--;
        }

    }
}
