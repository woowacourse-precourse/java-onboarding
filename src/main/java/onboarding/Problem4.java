package onboarding;

import java.util.*;

public class Problem4 {
    private static final Map<String,String> REVERSE_VALUE = new HashMap<>(){
        {
            put("A","Z"); put("B","Y");put("C","X");put("D","W");put("E","V");put("F","U");put("G","T");put("H","S");put("I","R");put("J","Q");put("K","P");put("L","O");put("M","N");
            put("N","M"); put("O","L");put("P","K");put("Q","J");put("R","I");put("S","H");put("T","G");put("U","F");put("V","E");put("W","D");put("X","C");put("Y","B");put("Z","A");
        }
    };
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        List<String> splitList = new ArrayList<>(Arrays.asList(word.split(""))) ;
        for(String s : splitList){
            if (isAlphabet(s)) {
                answer.append(switchValue(s));
            } else {
                answer.append(s);
            }
        }
        return answer.toString();
    }
    private static String switchValue(String originVal){
        if(originVal.equals(originVal.toUpperCase())){
            return REVERSE_VALUE.get(originVal);
        } else {
            return REVERSE_VALUE.get(originVal.toUpperCase()).toLowerCase();
        }
    }

    private static Boolean isAlphabet(String s){
        return s.matches("[a-zA-Z]") ;
    }
}
