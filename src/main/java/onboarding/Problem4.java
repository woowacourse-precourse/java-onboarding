package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] letters = word.toCharArray();
        HashMap<Character, Character> map = new HashMap<Character,Character>();

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(int i=0; i<alphabet.length;i++){map.put(alphabet[i],alphabet[alphabet.length-i-1]);}

        for (char letter : letters){
            answer += chgLetter(letter,map);
        }
        return answer;
    }
    static char chgLetter(Character letter,HashMap<Character,Character> map){
        if (map.get(Character.toLowerCase(letter)) == null){
            return letter;
        }else{
            if(Character.isLowerCase(letter)){return map.get(letter);}
            else{return Character.toUpperCase(map.get(Character.toLowerCase(letter)));}
        }
    }
}
