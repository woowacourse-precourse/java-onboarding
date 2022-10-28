package onboarding;

public class Problem4 {
    private static boolean isLower(char ch) {
        if (('a' <= ch) && (ch <= 'z')) {
            return true;
        }
        return false;
    }

    private static boolean isUpper(char ch) {
        if (('A' <= ch) && (ch <= 'Z')) {
            return true;
        }
        return false;
    }

    public static String solution(String word) {
        int alphabetSize = 26;
        char[] reverseLower = new char[alphabetSize];
        char[] reverseUpper = new char[alphabetSize];
        for (int index = 0; index < alphabetSize; index++) {
            reverseLower[index] = (char) ('z' - index);
            reverseUpper[index] = (char) ('Z' - index);
        }

        char[] converseWord = new char[word.length()];
        for (int index = 0; index < converseWord.length; index++) {
            char convert = word.charAt(index);
            if (isLower(convert)) {
                converseWord[index] = reverseLower[convert - 'a'];
            } else if (isUpper(convert)) {
                converseWord[index] = reverseUpper[convert - 'A'];
            } else {
                converseWord[index] = convert;
            }
        }

        return (new String(converseWord));
    }
}
