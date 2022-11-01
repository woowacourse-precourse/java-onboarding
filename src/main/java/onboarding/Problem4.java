package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        final StringBuilder sb = new StringBuilder();
        char[] wordChar = word.toCharArray();
        char[] converted = new char[wordChar.length];

        for (int i=0; i<wordChar.length; i++) {
            if (('a' <= wordChar[i]) && (wordChar[i] <= 'z')) {
                converted[i] = (char)('a' + ('z' - wordChar[i])) ;
            } else if (('A' <= wordChar[i]) && (wordChar[i] <='Z')) {
                converted[i] = (char)('A' + ('Z' - wordChar[i]));
            } else {
                converted[i] = wordChar[i];
            }
        }

        for (char c:converted) {
            sb.append(c);
        }

        answer = sb.toString();
        return answer;
    }
}
