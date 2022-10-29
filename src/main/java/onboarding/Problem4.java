package onboarding;


import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i<charArray.length; i++){
            if(charArray[i] == ' '){
                continue;
            } else {
                charArray[i] = revWord(charArray[i]);
            }

        }
        String answer = new String(charArray);
        return answer;
    }

    public static char revWord(char d) {
        Map<Character, Character> wordDiction = new HashMap<>(){{
            put('a','z');
            put('b','y');
            put('c','x');
            put('d','w');
            put('e','v');
            put('f','u');
            put('g','t');
            put('h','s');
            put('i','r');
            put('j','q');
            put('k','p');
            put('l','o');
            put('m','n');
            put('n','m');
            put('o','l');
            put('p','k');
            put('q','j');
            put('r','i');
            put('s','h');
            put('t','g');
            put('u','f');
            put('v','e');
            put('w','d');
            put('x','c');
            put('y','b');
            put('z','a');
        }};


        if(Character.isLowerCase(d)) {
            return wordDiction.get(d);
        } else {
            return Character.toUpperCase(wordDiction.get(Character.toLowerCase(d)));
        }
    }
}
