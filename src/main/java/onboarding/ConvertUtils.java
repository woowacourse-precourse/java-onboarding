package onboarding;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertUtils {

    private static final int LARGE_A = 65;
    private static final int LARGE_Z = 90;
    private static final int SMALL_A = 97;
    private static final int SMALL_Z = 122;

    private final String word;
    private final Map<Character, Character> convertReverseCharacterMap;

    public ConvertUtils(String word, int reverseSize) {
        this.word = word;
        this.convertReverseCharacterMap = getConvertReverseCharacterMap(reverseSize);
    }

    public Map<Character, Character> getConvertReverseCharacterMap(int reverseSize) {
        Map<Character, Character> convertReverseCharacterMap = new HashMap<>();
        for (int i = 0; i < reverseSize; i++) {
            convertReverseCharacterMap.put((char) (LARGE_A + i), (char) (LARGE_Z - i));
            convertReverseCharacterMap.put((char) (LARGE_Z - i), (char) (LARGE_A + i));
            convertReverseCharacterMap.put((char) (SMALL_A + i), (char) (SMALL_Z - i));
            convertReverseCharacterMap.put((char) (SMALL_Z - i), (char) (SMALL_A + i));
        }
        convertReverseCharacterMap.put(' ', ' ');
        return convertReverseCharacterMap;
    }

    public String convertToReverseWord() {
        return word.chars()
                .mapToObj(i -> (char) i)
                .map(w -> convertReverseCharacterMap.get(w))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
