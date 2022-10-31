package problem2;

import java.util.*;
import java.util.stream.Collectors;

public class ContinuousDuplicationDeleter {
    public static String deleteFrom(String target) {
        List<Character> chars = Arrays.stream(target.split(""))
                .map(str -> Character.valueOf(str.charAt(0)))
                .collect(Collectors.toList());

        List <Character> result = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            Character character = chars.get(i);
            if (isDifferentWithPrev(chars, i) && isDifferentWithNext(chars, i)) {
                result.add(character);
            }
        }

        return asString(result);
    }

    static boolean hasDuplication(String target) {
        for (int i = 0; i < target.length() - 1; i++) {
            if (target.charAt(i) == target.charAt(i + 1)) return true;
        }
        return false;
    }
    private static boolean isDifferentWithPrev(List<Character> characters, int index) {
        return index == 0 || !characters.get(index - 1).equals(characters.get(index));
    }

    private static boolean isDifferentWithNext(List<Character> characters, int index) {
        return index == characters.size() - 1 || !characters.get(index + 1).equals(characters.get(index));
    }


    private static String asString(List<Character> characters) {
        StringBuilder sb = new StringBuilder();

        for (Character character : characters) {
            sb.append(character);
        }

        return sb.toString();
    }
}
