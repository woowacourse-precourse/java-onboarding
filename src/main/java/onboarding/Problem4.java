package onboarding;

import onboarding.support.problem4.DictionaryConverter;

public class Problem4 {

    public static String solution(String word) {
        DictionaryConverter dictionaryConverter = new DictionaryConverter(word);
        return dictionaryConverter.getConvertedString();
    }
}
