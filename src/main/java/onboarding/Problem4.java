package onboarding;

public class Problem4 {
    public static String solution(String word) {

        StringBuilder answer = new StringBuilder();

        for (char alphabet : word.toCharArray()) {
            answer.append(reverseAlphabet(alphabet));
        }
        return answer.toString();
    }
    public static char reverseAlphabet(char alphabet) {
        if ('A' <= alphabet && alphabet <= 'Z') {
            return (char) ('Z' - alphabet + 'A');
        } else if ('a' <= alphabet && alphabet <= 'z') {
            return (char) ('z' - alphabet + 'a');
        }
        return alphabet;
    }
}