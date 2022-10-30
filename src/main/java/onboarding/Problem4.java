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
}
