package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder(word);

        for (int i=0;i<sb.length();i++) {
            char value3 = sb.charAt(i);
            if (value3 >= 'a' && value3 <= 'z') {
                value3 = (char) ('z' - (value3 - 'a'));
                sb.setCharAt(i,value3);
            }

            if (value3 >= 'A' && value3 <= 'Z') {
                value3 = (char) ('Z' - (value3 - 'A'));
                sb.setCharAt(i,value3);
            }
        }
        return sb.toString();
    }
}
