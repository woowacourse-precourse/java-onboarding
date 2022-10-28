package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            getGreenFrogChar(word.charAt(i));
        }

        return answer;
    }

    private static void getGreenFrogChar(char originalChar) {
        System.out.println(originalChar);
    }
}
