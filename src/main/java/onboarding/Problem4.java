package onboarding;

import java.util.HashMap;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    static HashMap<Character, Character> makeHashMap() {
        HashMap<Character, Character> alphabetHash = new HashMap<>();

        alphabetHash.put(' ', ' ');

        for (int i = 0; i < 26; i++) {
            alphabetHash.put((char) (65 + i), (char) (90 - i));
            alphabetHash.put((char) (97 + i), (char) (122 - i));
        }

        return alphabetHash;
    }
}
