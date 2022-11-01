package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        HashMap<Character, Character> map = new HashMap<>();
        char a = 65;
        char b = 90;
        char c = 97;
        char d = 122;
        for(int i = 0; i < 25; i++) {
            map.put(a,b);
            map.put(c, d);
            a++;
            b--;
            c++;
            d--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char current = ' ';
            if(word.charAt(i) >= 65 && word.charAt(i) <= 90) { 		//대문자이면
                current = (char) (word.charAt(i) + 32);
                current = map.get(current);
            }
            else if(word.charAt(i) >=97 && word.charAt(i) <= 122) {	//소문자이면
                current = (char) (word.charAt(i) - 32);
                current = map.get(current);
            }
            sb.append(c);
        }


        return sb.toString();
    }
}
