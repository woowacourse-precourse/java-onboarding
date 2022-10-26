package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = getConversionWord(word);
        return answer;
    }

    static String getConversionWord(String word) {
        int len = word.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char character = word.charAt(i);
            if (isUpperCase(character)) {
                result.append(upperCaseConversion(character));
            }
            else if (isLowerCase(character)) {
                result.append(lowerCaseConversion(character));
            }
            else {
                result.append(character);
            }
        }

        return result.toString();
    }

    static boolean isUpperCase(char character) {
        if (character >= 'A' && character <= 'Z') {
            return true;
        }
        return false;
    }

    static boolean isLowerCase(char character) {
        if (character >= 'a' && character <= 'z') {
            return true;
        }
        return false;
    }

    static Character upperCaseConversion(char character) {
        int move = character - 'A';
        char result =  (char) ('Z' - move);

        return result;
    }

    static Character lowerCaseConversion(char character) {
        int move = character - 'a';
        char result = (char) ('z' - move);

        return result;
    }

    public static void main(String[] args) {
        String word = "I l@ve $un";
        System.out.println(solution(word));
    }
}
