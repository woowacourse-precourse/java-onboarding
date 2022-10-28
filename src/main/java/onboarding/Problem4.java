package onboarding;

public class Problem4 {
    public static String solution(String word) {
        Map<Character, Character> frogDictionary = new HashMap<>();
        String answer = "";

        for (int i = 0; i < 26; i++) {
            Character alpha = (char) ('A' + i);
            frogDictionary.put(alpha, (char)('Z' - i));
        }

        return answer;
    }
}
