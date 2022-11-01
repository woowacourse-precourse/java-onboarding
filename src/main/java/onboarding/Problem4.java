package onboarding;

import onboarding.problem4.CompareWords;
import onboarding.problem4.DictionaryGenerator;

import java.util.Map;

public class Problem4 {
    public static String solution(String word) {

        DictionaryGenerator generator = new DictionaryGenerator();
        Map<Character, Character> characterMap = generator.createDictionary();

        CompareWords compareWords = new CompareWords();
        String answer = compareWords.compareSplit(characterMap, word);

        return answer;
    }
}
