package onboarding;

public class Problem2 {
    public static String removeDuplicate(String str) {
        for (int i = 0; i < 26; i++) {
            String letter = Character.toString((char)((int)'a' + i));
            String pattern = letter + "{2,}";
            str = str.replaceAll(pattern, "");
        }
        return str;
    }

    public static String solution(String cryptogram) {
        String prevStr = cryptogram;
        String nextStr = removeDuplicate(cryptogram);

        while (prevStr != nextStr) {
            prevStr = nextStr;
            nextStr = removeDuplicate(prevStr);
        }

        String answer = nextStr;
        return answer;
    }
}
