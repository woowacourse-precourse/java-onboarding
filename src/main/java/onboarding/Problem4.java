package onboarding;

import java.util.HashMap;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        HashMap<Character, Character> alphabetHash = makeHashMap();
        for (char c : word.toCharArray()) {
            if (alphabetHash.containsKey(c)) {
                answer.append(alphabetHash.get(c));
                continue;
            }
            answer.append(c);
        }
        return answer.toString();
    }

    static HashMap<Character, Character> makeHashMap() {
        HashMap<Character, Character> alphabetHash = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            alphabetHash.put((char) (65 + i), (char) (90 - i));
            alphabetHash.put((char) (97 + i), (char) (122 - i));
        }

        return alphabetHash;
    }
}
