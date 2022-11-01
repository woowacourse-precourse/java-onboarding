package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // 하나씩 변환해서 answer로 만든다.
        for (int i = 0; i < word.length(); i++) {
            answer += changeCharacter(word.charAt(i));
        }
        
        return answer;
    }

    private static String changeCharacter(char character) {
        if (isCharacterUpperCase(character)) {
            return getShiftedCharacterWithOffset('Z', getOffset('A', character));
        } else if (isCharacterLowerCase(character)) {
            return getShiftedCharacterWithOffset('z', getOffset('a', character));
        }
        return character;
    }

    private static char getShiftedCharacterWithOffset(char standardCharacter, Integer offset) {
    }

    private static Integer getOffset(char standardCharacter, char character) {
        return character - standardCharacter;
    }

    private static boolean isCharacterUpperCase(char character) {
        if (character >= 'A' && character <= 'Z') return true;
        return false;
    }

    private static boolean isCharacterLowerCase(char character) {
        if (character >= 'a' && character <= 'z') return true;
        return false;
    }

}
