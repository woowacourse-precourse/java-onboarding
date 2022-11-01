package onboarding.problem2;

public class Cryptogram {

    /*
     * 를
     */
    public static String removeDuplicateCharacters(String str) {
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
}
