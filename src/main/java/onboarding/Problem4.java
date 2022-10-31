package onboarding;

public class Problem4 {

    static final char[] UPPER = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static final char[] LOWER = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    static int conversionLower(char c) {
        return 25 - (c - 'a');
    }

    static int conversionUpper(char c) {
        return 25 - (c - 'A');
    }
}
