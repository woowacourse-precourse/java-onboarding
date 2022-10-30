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

        return answer;
    }

    private static void setConvertTable(Map<Character, Character> convertTable) {
        for (int i = 0; i <= (Z_DECIMAL - A_DECIMAL); i++) {
            convertTable.put((char) (A_DECIMAL + i), (char) (Z_DECIMAL - i));
        }
    }
}
