package onboarding;

public class Problem4 {
    /*
    A - Z : 65 ~ 90
    a - z : 97 ~ 122
    */
    public static String solution(String word) {
        StringBuffer sb = new StringBuffer();
        char[] motherWord = word.toCharArray();

        for (char character : motherWord) {
            char result = toTreeFrogWord(character);
            sb.append(result);
        }
        return sb.toString();
    }

    public static char toTreeFrogWord(char character) {
        int ascii = -1;
        if(character == ' ') {
            return ' ';
        }

        if(character >= 'A' && character <= 'Z') {
            ascii = character - 'A';
            character = (char) ('Z' - ascii);
            return character;
        }

        ascii = character - 'a';
        character = (char) ('z' - ascii);
        return character;
    }
}
