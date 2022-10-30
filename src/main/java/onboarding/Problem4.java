package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {

    public static String solution(String sentence) {
        try {
            validate(sentence);
            String answer = getReverseSentence(sentence);
            return answer;
        } catch (Exception e) {
            System.out.println(e);
            return "Wrong input";
        }
    }

    static String getReverseSentence(String sentence) {
        List<Character> characterList = convertStringToArrayList(sentence);
        List<Character> reverseCharacterList = getReverseCharacterList(characterList);
        String reverseSentence = joinCharactersInArrayList(reverseCharacterList);
        return reverseSentence;
    }

    static List<Character> convertStringToArrayList(String sentence) {
        char[] characterArray = sentence.toCharArray();
        List<Character> characterList = new ArrayList<>();
        for (char character : characterArray) {
            characterList.add(character);
        }
        return characterList;
    }

    static List<Character> getReverseCharacterList(List<Character> characterList) {
        List<Character> reverseCharacterList = new ArrayList<>();
        for (int i = 0; i < characterList.size(); i++) {
            char character = characterList.get(i);
            char reverseCharacter = Dictionary.getReverseCharacter(character);
            reverseCharacterList.add(i, reverseCharacter);
        }
        return reverseCharacterList;
    }

    static String joinCharactersInArrayList(List<Character> characterList) {
        String[] stringArray = characterList.stream()
            .map(character -> String.valueOf(character))
            .toArray(String[]::new);
        String result = String.join("", stringArray);
        return result;
    }

    static void validate(String sentence) throws Exception {
        int length = sentence.length();
        if (length < 1 || length > 1000) {
            throw new Exception("길이가 1 이상 1000 이하인 문자열만 입력할 수 있습니다");
        }
    }
}

class Dictionary {

    static char getReverseCharacter(char character) {
        int ascii = character;
        int reverseAscii = getReverseByAscii(ascii);
        char reverseCharacter = (char) reverseAscii;
        return reverseCharacter;
    }

    static int getReverseByAscii(int ascii) {
        int reverseAscii = ascii;
        if (ascii >= 65 && ascii <= 90) {
            reverseAscii = 90 - (ascii - 65);
        }
        if (ascii >= 97 && ascii <= 122) {
            reverseAscii = 122 - (ascii - 97);
        }
        return reverseAscii;
    }
}
