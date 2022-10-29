package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static HashMap<Character,Character> map = new HashMap<Character,Character>(){{
        for(int i = 97; i<=122; i++){
            put((char)i, (char)(219-i));
        }
    }};

    private static Character mapping(Character c){
        if (Character.isAlphabetic(c)){
            char mom = Character.toLowerCase(c);
            char son = (Character.isUpperCase(c)) ? Character.toUpperCase(map.get(mom)): map.get(mom);
            return son;
        }
        else return c;
    }

    public static String solution(String word) {
        StringBuffer ans = new StringBuffer();

        for(int i = 0; i<word.length(); i++){
            ans.append(mapping(word.charAt(i)));
        }

        return ans.toString();
    }
}
