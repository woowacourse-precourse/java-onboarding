package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return getResultInStringRange(word);
    }

    private static String getResultInStringRange(String word) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); i++) {
            String changeChar = checkChar(word.charAt(i));
            sb.append(changeChar);
        }

        return sb.toString();
    }

    private static String checkChar(char character) {
        if(character == ' ') {
            return " ";
        }
        else if('A' <= character && character <= 'Z') {
            return toString('A', character, 'Z');
        }
        else if('a' <= character && character <= 'z') {
            return toString('a', character, 'z');
        }

        return String.valueOf(character);
    }

    private static String toString(char lastChar, char nowChar, char firstChar) {
        return String.valueOf((char) (lastChar - nowChar + firstChar));
    }
}
