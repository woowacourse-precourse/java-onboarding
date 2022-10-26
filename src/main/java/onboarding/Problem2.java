package onboarding;

public class Problem2 {
    
    static char[] chars;
    static boolean hasNotDuplicate;
    static String answer;
    static StringBuilder newCryptogram;
    static char duplicateChar;
    
    static void setUp(String cryptogram) {
        chars = cryptogram.toCharArray();
        hasNotDuplicate = false;
        answer = "";
    }

    private static void findDuplicateCharacter() {
        newCryptogram = new StringBuilder();
        duplicateChar = ' ';
        hasNotDuplicate = true;
        for (int i = 0; i < chars.length; i++) {
            if (FirstCharacter(i)) {
                if (notDuplicateNextCharacter(i, chars[i])) {
                    newCryptogram.append(chars[i]);
                }
                continue;
            }

            if (LastCharacter(i)) {
                if (notDuplicatePrevCharacter(i, chars[i]) && notDuplicateCharacter(chars[i])) {
                    newCryptogram.append(chars[i]);
                }
                continue;
            }

            if (DuplicateCharacter(i, chars[i])) {
                duplicateChar = chars[i];
                hasNotDuplicate = false;
                continue;
            }
            
            if (notDuplicateNextCharacter(i, chars[i])) {
                if (notDuplicateCharacter(chars[i])) {
                    newCryptogram.append(chars[i]);
                    duplicateChar = ' ';
                }
            }
        }
        chars = newCryptogram.toString().toCharArray();
        if (hasNotDuplicate) {
            answer = newCryptogram.toString();
        }
    }

    private static boolean DuplicateCharacter(int i, char character) {
        return character == chars[i + 1];
    }

    private static boolean notDuplicateCharacter(char character) {
        return character != duplicateChar;
    }

    private static boolean notDuplicateNextCharacter(int i, char character) {
        return character != chars[i + 1];
    }

    private static boolean notDuplicatePrevCharacter(int i, char character) {
        return character != chars[i - 1];
    }
    
    private static boolean LastCharacter(int i) {
        return i == chars.length - 1;
    }

    private static boolean FirstCharacter(int i) {
        return i == 0;
    }

    public static String solution(String cryptogram) {

        setUp(cryptogram);
        while (!hasNotDuplicate) {
            findDuplicateCharacter();
        }
        return answer;
    }



}
