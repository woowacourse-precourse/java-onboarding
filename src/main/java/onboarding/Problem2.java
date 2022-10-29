package onboarding;

public class Problem2 {

    private static boolean checkDuplicateCharacters(String str) {

        char[] chars = str.toCharArray();
        char previousChar = chars[0];

        for(int i = 1; i < chars.length; i++) {
            char currentChar = chars[i];

            if(previousChar == currentChar) return true;
            else previousChar = currentChar;
        }

        return false;
    }
}
