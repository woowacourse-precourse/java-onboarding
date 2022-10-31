package onboarding.p4;

import java.util.HashMap;
import java.util.Map;

public class GreenFrogDictionary implements Dictionary{
    // 청개구리 사전
    Map<Character, Character> dictionary = new HashMap<>() {{
            put('A', 'Z');
            put('B', 'Y');
            put('C', 'X');
            put('D', 'W');
            put('E', 'V');
            put('F', 'U');
            put('G', 'T');
            put('H', 'S');
            put('I', 'R');
            put('J', 'Q');
            put('K', 'P');
            put('L', 'O');
            put('M', 'N');
            put('N', 'M');
            put('O', 'L');
            put('P', 'K');
            put('Q', 'J');
            put('R', 'I');
            put('S', 'H');
            put('T', 'G');
            put('U', 'F');
            put('V', 'E');
            put('W', 'D');
            put('X', 'C');
            put('Y', 'B');
            put('Z', 'A');
    }};

    // 사전을 토대로 문자열을 변환
    @Override
    public String convertString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] chars = str.toCharArray();
        StringBuilder convertString = new StringBuilder();

        for (char c : chars) {
            char toChar = c;
            if (c >= 'A' && c <= 'Z') {
                toChar = dictionary.get(c);
            } else if (c >= 'a' && c <= 'z') {
                toChar = dictionary.get(Character.toUpperCase(c));
                toChar += 32;
            }
            convertString.append(toChar);
        }

        return convertString.toString();
    }
}
