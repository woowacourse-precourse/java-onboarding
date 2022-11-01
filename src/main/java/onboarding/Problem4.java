package onboarding;

import java.util.List;
import java.util.stream.Collectors;

class ReverseAlphabetList {
    private List<Character> characters;

    public ReverseAlphabetList(List<Character> characters) {
        validateSize(characters);
        this.characters = characters;
    }

    public List<Character> reverse() {
        /* ASCII 코드를 활용해 소문자(65~90), 대문자(97~122) 알파벳을 반대로 변환*/
        List<Character> characterList = this.characters;
        characterList = reverseUpperCase(characterList);
        characterList = reverseLowerCase(characterList);
        return characterList;
    }

    private List<Character> reverseUpperCase(List<Character> characters) {
        characters.replaceAll(c -> (int) c >= 65 && (int) c <= 90 ? (char) (90 + 65 - (int) c) : c);
        return characters;
    }

    private List<Character> reverseLowerCase(List<Character> characters) {
        characters.replaceAll(c -> (int) c >= 97 && (int) c <= 122 ? (char) (122 + 97 - (int) c) : c);
        return characters;
    }

    private void validateSize(List<Character> characters) {
        if (characters.size() == 0 || characters.size() > 1000) {
            throw new IllegalArgumentException("characters must be between 1 and 1000");
        }
    }
}

public class Problem4 {
    public static String solution(String word) {
        List<Character> characters = word.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        ReverseAlphabetList alphabetList = new ReverseAlphabetList(characters);
        String answer = alphabetList.reverse().stream() // 문자열 String으로 변환
                .map(String::valueOf)
                .collect(Collectors.joining());
        return answer;
    }
}