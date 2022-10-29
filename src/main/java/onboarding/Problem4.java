package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        answer = reverseString(word, answer);
        return answer;
    }

    private static String reverseString(String word, String answer) {
        for (int i = 0; i < word.length(); i++) {
            char now_word = word.charAt(i);
            answer = putReverseChar(answer, now_word);
        }
        return answer;
    }

    private static String putReverseChar(String answer, char now_word) {
        if (isUpperReverse(now_word)) {
            answer += (char) changeReverse('Z', now_word, 'A');
        } else if (isLowerReverse(now_word)) {
            answer += (char) changeReverse('z', now_word, 'a'); 
        } else {
            answer += now_word; 
        }
        return answer;
    }

    private static int changeReverse(char z, char reverse, char a) {
        return (z - reverse) + a;
    }

    private static boolean isLowerReverse(char reverse) {
        return reverse >= 'a' && reverse <= 'z';
    }

    private static boolean isUpperReverse(char reverse) {
        return reverse >= 'A' && reverse <= 'Z';
    }
}
