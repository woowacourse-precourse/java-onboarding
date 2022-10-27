package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static Map<Character, Character> map = new HashMap<>() {
        {
            put('A','Z'); put('B', 'Y'); put('C', 'X'); put('D', 'W'); put('E', 'V'); put('F', 'U'); put('G', 'T'); put('H', 'S'); put('I', 'R'); put('J', 'Q');
            put('K', 'P'); put('L', 'O'); put('M', 'N'); put('N', 'M'); put('O', 'L'); put('P', 'K'); put('Q', 'J'); put('R', 'I'); put('S', 'H'); put('T', 'G');
            put('U', 'F'); put('V', 'E'); put('W', 'D'); put('X', 'C'); put('Y', 'B'); put('Z', 'A');
        }
    };

    public static boolean checkAlphabet(Character ch){
        if( (ch >= 'a' && ch <='z') || (ch >= 'A' && ch <='Z') ) return true;
        return false;
    }

    public static Character changeAlphabet(Character ch){
        if(Character.isUpperCase(ch)){
            ch = map.get(ch);
        }else{
            ch = Character.toUpperCase(ch);
            ch = Character.toLowerCase(map.get(ch));
        }

        return ch;
    }

    public static String solution(String word) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if(checkAlphabet(ch)){
                ch = changeAlphabet(ch);
            }
            stringBuffer.append(ch);
        }
        return stringBuffer.toString();
    }
}
