package onboarding;

public class Problem2 {

    private static String removeDuplicateCharacters(String str) {
        char[] chars = str.toCharArray();
        char previousChar = chars[0];

        StringBuilder results = new StringBuilder();
        results.append(previousChar);

        for(int i = 1; i < chars.length; i++) {
            char currentChar = chars[i];
            if(previousChar != currentChar) {

                results.append(currentChar);
                previousChar = currentChar;
            } else {

                results.deleteCharAt(results.length() - 1);
            }
        }

        return results.toString();
    }

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
