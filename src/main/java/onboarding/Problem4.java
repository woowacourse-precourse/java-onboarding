package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) {
                if (Character.isLowerCase(word.charAt(i))) {
                    answer += "" + (char) (122 - word.charAt(i) + 97);
                } else if (Character.isUpperCase(word.charAt(i))) {
                    answer += "" + (char) (90 - word.charAt(i) + 65);
                }
            } else {
                answer = answer + word.charAt(i);
            }
        }
        return answer;
    }
}
