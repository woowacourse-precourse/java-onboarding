package onboarding;

public class Problem2 {
    private static int start, end;
    private static boolean flag;
    private static char character;

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static void getSameCharacterIndex(String cryptogram) {
        start = -1;
        flag = false;
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (compareIndex(cryptogram.charAt(i), cryptogram.charAt(i + 1), i)) {
                return;
            }
        }
    }

    private static boolean compareIndex(char firstCharacter, char secondCharacter, int index) {
        if (firstCharacter == secondCharacter) {
            if (!flag) {
                flag = true;
                start = index;
                end = index + 1;
                character = firstCharacter;
                return false;
            }
            if (firstCharacter == character) {
                end = index + 1;
                return false;
            }
            return true;
        }
        return false;
    }
}
