package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Map<String, String> alphabet = new HashMap<String, String>();
        alphabet.put("A","Z");
        alphabet.put("B","Y");
        alphabet.put("C","X");
        alphabet.put("D","W");
        alphabet.put("E","V");
        alphabet.put("F","U");
        alphabet.put("G","T");
        alphabet.put("H","S");
        alphabet.put("I","R");
        alphabet.put("J","Q");
        alphabet.put("K","P");
        alphabet.put("L","O");
        alphabet.put("M","N");
        alphabet.put("N","M");
        alphabet.put("O","L");
        alphabet.put("P","K");
        alphabet.put("Q","J");
        alphabet.put("R","I");
        alphabet.put("S","H");
        alphabet.put("T","G");
        alphabet.put("U","F");
        alphabet.put("V","E");
        alphabet.put("W","D");
        alphabet.put("X","C");
        alphabet.put("Y","B");
        alphabet.put("Z","A");
        alphabet.put("a","z");
        alphabet.put("b","y");
        alphabet.put("c","x");
        alphabet.put("d","w");
        alphabet.put("e","v");
        alphabet.put("f","u");
        alphabet.put("g","t");
        alphabet.put("h","s");
        alphabet.put("i","r");
        alphabet.put("j","q");
        alphabet.put("k","p");
        alphabet.put("l","o");
        alphabet.put("m","n");
        alphabet.put("n","m");
        alphabet.put("o","l");
        alphabet.put("p","k");
        alphabet.put("q","j");
        alphabet.put("r","i");
        alphabet.put("s","f");
        alphabet.put("t","g");
        alphabet.put("u","f");
        alphabet.put("v","e");
        alphabet.put("w","d");
        alphabet.put("x","c");
        alphabet.put("y","b");
        alphabet.put("z","z");

        for(int i=0; i<word.length(); i++) {
           if(alphabet.containsKey(word.substring(i, i + 1))){
                answer=answer+alphabet.get(word.substring(i, i + 1));
            }else{
               answer=answer+word.substring(i, i + 1);
           }
        }



        return answer;
    }
}
