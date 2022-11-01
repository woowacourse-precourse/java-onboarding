package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeDuplicated(cryptogram);
    }

    private static String removeDuplicated(String cryptogram) {
        List<Character> characters = convertToCharList(cryptogram);
        int prev = 0;
        int after = -1;

        while (prev != after && after != 0) {
            prev = characters.size();
            List<Character> newCharacters = removeDuplicateCharacters(characters);
            updateList(characters, newCharacters);
            after = characters.size();
        }

        if (characters.isEmpty()) {
            return "";
        }
        return characters.stream().map(Object::toString)
                .reduce((acc, character) -> acc + character)
                .get();
    }

    private static List<Character> convertToCharList(String cryptogram) {
        return cryptogram.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    private static List<Character> removeDuplicateCharacters(List<Character> characters) {
        List<Character> newCharacters = new ArrayList<>();
        int index = 0;

        for (; index < characters.size() - 1; index++) {
            if (characters.get(index) == characters.get(index + 1)) {
                index += 1;
                continue;
            }
            newCharacters.add(characters.get(index));
        }

        if (characters.get(characters.size() - 2) != characters.get(characters.size() - 1)) {
            newCharacters.add(characters.get(characters.size() - 1));
        }
        return newCharacters;
    }

    private static void updateList(List<Character> characters, List<Character> newCharacters) {
        characters.clear();
        characters.addAll(newCharacters);
    }
}
