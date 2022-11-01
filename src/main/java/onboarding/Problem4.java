package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static final int A_DECIMAL = 65;
    public static final int Z_DECIMAL = 90;

    public static String solution(String word) {
        String answer = "";

        Map<Character, Character> convertTable = new HashMap<>();

        setConvertTable(convertTable);

        StringBuilder convertResult = new StringBuilder();

        for (char letter : word.toCharArray()) {

            if (Character.isWhitespace(letter)) {
                convertResult.append(letter);
                continue;
            }

            boolean checkLower = Character.isLowerCase(letter);
            char afterConvert = convertTable.get(Character.toUpperCase(letter));

            if (checkLower) {
                afterConvert = Character.toLowerCase(afterConvert);
            }

            convertResult.append(afterConvert);
        }

        answer = convertResult.toString();
        
        return answer;
    }

    private static void setConvertTable(Map<Character, Character> convertTable) {
        for (int i = 0; i <= (Z_DECIMAL - A_DECIMAL); i++) {
            convertTable.put((char) (A_DECIMAL + i), (char) (Z_DECIMAL - i));
        }
    }
}
