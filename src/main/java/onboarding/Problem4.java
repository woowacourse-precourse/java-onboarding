package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                answer += changeUpperCase(word.charAt(i));
            } else if(Character.isLowerCase(word.charAt(i))) {
                answer += changeLowerCase(word.charAt(i));
            } else {
                answer += word.charAt(i);
            }
        }
        return answer;
    }

    private static char changeUpperCase(char c) {
        int result = 65 - (int)c + 90;
        return (char)result;
    }

    private static char changeLowerCase(char c) {
        int result = 97 - (int)c + 122;
        return (char)result;
    }
}
