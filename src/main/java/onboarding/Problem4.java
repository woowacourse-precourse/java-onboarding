package onboarding;

public class Problem4 {

    // 문자열 변환
    private static String convertString(String word) {
        String convertString = "";

        for(int i = 0; i < word.length(); i++) {
            if (isAlphabet(word.charAt(i))) {
                convertString += convertChar(word.charAt(i));
            } else {
                convertString += word.charAt(i);
            }
        }

        return convertString;
    }

    public static String solution(String word) {
        return convertString(word);
    }
}
