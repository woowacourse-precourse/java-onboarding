package onboarding;

import model.Treefrog;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        HashMap<Character, Character> dictionary = new HashMap<>() {{
            for (int i = 0; i <= ((int) 'Z' - (int) 'A'); i++) {
                char key = (char) ((int) 'A' + i);
                char value = (char) ((int) 'Z' - i);
                put(key, value);
            }
        }};
        Treefrog treefrog = new Treefrog(word, dictionary);
        return treefrog.frogTalking();
    }
}
