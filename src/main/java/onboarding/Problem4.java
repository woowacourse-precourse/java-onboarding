package onboarding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        List<Character> alphabets = Arrays.asList('a','b','c','d','e','f'
                ,'g','h','i','j','k','l','m','n','o','p'
                ,'q','r','s','t','u','v','w','x','y','z');
        HashMap<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0; i < alphabets.size(); i++){
            map.put(alphabets.get(i), alphabets.get(25 - i));
            map.put(alphabets.get(i).toString().toUpperCase().charAt(0), alphabets.get(25 - i).toString().toUpperCase().charAt(0));
        }

        for (int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z')
                answer += map.get(c);
            else
                answer += c;
        }

        return answer;
    }
}
