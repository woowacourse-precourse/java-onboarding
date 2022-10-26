package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
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
        System.out.println(lowerCaseConversion('z'));
    }
}
