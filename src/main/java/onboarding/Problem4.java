package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static void main(String[] args){
        solution("I love you");
    }
    public static String solution(String word) {
        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder answer = new StringBuilder();
        setValue(map);
        for(int i = 0; i < word.length(); i++){
            answer.append(map.get(word.charAt(i)));
        }
        System.out.println(answer);
        return answer.toString();
    }

    public static void setValue(HashMap<Character, Character> map){
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
}
