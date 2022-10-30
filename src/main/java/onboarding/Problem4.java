package onboarding;

import java.util.ArrayList;

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
        ArrayList<Character> characterList = convertStringToArrayList(sentence);
        ArrayList<Character> reverseCharacterList = getReverseCharacterList(characterList);
        String reverseSentence = joinCharactersInArrayList(reverseCharacterList);
        return reverseSentence;
    }

    static ArrayList<Character> convertStringToArrayList(String sentence) {
        char[] characterArray = sentence.toCharArray();
        ArrayList<Character> characterList = new ArrayList<>();
        for (char character : characterArray) {
            characterList.add(character);
        }
        return characterList;
    }

    static ArrayList<Character> getReverseCharacterList(ArrayList<Character> characterList) {
        ArrayList<Character> reverseCharacterList = new ArrayList<>();
        for (int i = 0; i < characterList.size(); i++) {
            char character = characterList.get(i);
            char reverseCharacter = Dictionary.getReverseCharacter(character);
            reverseCharacterList.add(i, reverseCharacter);
        }
        return reverseCharacterList;
    }

    static String joinCharactersInArrayList(ArrayList<Character> characterArrayList) {
        String[] stringArray = characterArrayList.stream()
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
