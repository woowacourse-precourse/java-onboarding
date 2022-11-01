package onboarding;

public class Problem4 {

    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 1000;

    public static String solution(String word) {
        validateRange(word);

        char[] charArray = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char chWord : charArray) {
            sb.append(changeAlphabet(chWord));
        }

        String answer = sb.toString();
        return answer;
    }

    private static char changeAlphabet(char ch) {
        // 65~90 (A~Z), 97~122 (a~z)
        // 65 -> 90 , 66 -> 89
        int changeAscii = (int)ch;
        if (changeAscii >= 65 && changeAscii <= 90) {
            return (char)(91 - (changeAscii - 64));
        }
        if (changeAscii >= 97 && changeAscii <= 122) {
            return (char)(123 - (changeAscii - 96));
        }
        return ch;
    }

    private static void validateRange(String input) {
        int inputLength = input.length();
        if (inputLength < MIN_RANGE_NUM || inputLength > MAX_RANGE_NUM) {
            throw new IllegalArgumentException("엄마 말씀은 길이가 1 이상 1000 이하인 문자열이다.");
        }
    }
}
