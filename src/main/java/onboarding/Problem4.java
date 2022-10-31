package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static int[] convertStringtoASCIICode(String word) {
        char[] words = word.toCharArray();
        int[] asciiCodes = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            asciiCodes[i] = words[i];
        }

        return asciiCodes;
    }
}
