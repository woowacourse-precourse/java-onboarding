package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static final HashMap<Character, Character> map = new HashMap<>();
    public static String solution(String word) {
        setValue();
        return findWordOpposite(word);
    }

    public static void setValue(){
        int start = 0;
        map.put(' ', ' ');
        for(int i = 65; i < 91; i++){
            map.put((char)i, (char)(90 - start));
            start += 1;
        }
        start = 0;
        for(int i = 97; i < 123; i++){
            map.put((char)i, (char)(122 - start));
            start += 1;
        }
    }

    public static String findWordOpposite(String word){
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            answer.append(map.get(word.charAt(i)));
        }
        return answer.toString();
    }
}
