package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String sentence) {
        String answer = getReverseSentence(sentence);
        return answer;
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
        for (char character: characterArray) {
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
}
