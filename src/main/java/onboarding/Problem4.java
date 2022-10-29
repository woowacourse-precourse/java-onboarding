package onboarding;

public class Problem4 {
    public static void main(String[] args) {
        String word = "I love you";
        System.out.println(solution(word));
    }
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        int strLen = word.length();

        for (int i = 0; i < strLen; i++) {
            Character c = word.charAt(i);

            if ((int) c >= 65 && (int) c <= 90) {
                sb.append((char)(90 - ((int) c - 65)));
            } else if ((int) c >= 97 && (int) c <= 122) {
                sb.append((char) (122 - ((int) c - 97)));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
