package onboarding;

public class Problem4 {
    public static String converWord(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            int each = word.charAt(i);

            if (each >= 97 && 122 >= each) {
                answer += (char) (219 - each);
            } else if (each >= 65 && 90 >= each) {
                answer += (char) (155 - each);
            } else {
                answer += (char) each;
            }
        }

        return answer;
    }

    public static String solution(String word) {
        String answer = converWord(word);
        return answer;
    }
}