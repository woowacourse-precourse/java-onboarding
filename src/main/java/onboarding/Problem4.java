package onboarding;

public class Problem4 {
    public static HashMap<Character, Character> fullmap () {
        HashMap<Character, Character> changeChar = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            changeChar.put((char) (65 + i), (char) (90 - i));
        }
        return changeChar;
        }


    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
