package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] wordArray = word.toCharArray();

        for (char c : wordArray) {

            if (c == ' ') {
                answer += ' ';
                continue;
            }

            if (Character.isUpperCase(c)) {
                answer += reverse(c,155);
            } else {
                answer += reverse(c,219);
            }
        }
        return answer;
    }


    public static char reverse(char c, int total) {

        int ascii = c;

        return (char) (total - ascii);
    }


    public static void main(String[] args) {

        String word = "I love you";

        System.out.println(solution(word));
    }
}
