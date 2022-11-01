package onboarding;

public class Problem4 {

    // public static void main(String[] args) {
    // String k = "I love you";
    // System.out.println(solution(k));
    // }

    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ')
                answer += ' ';
            else if ('a' < word.charAt(i) && word.charAt(i) < 'z')
                answer += (char) ('a' + 'z' - word.charAt(i));
            else if ('A' < word.charAt(i) && word.charAt(i) < 'Z')
                answer += (char) ('A' + 'Z' - word.charAt(i));
        }
        return answer;
    }
}
