package onboarding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem4 {

//    protected  static String SPACE = " ";
    protected static final Map<String,String> REVERSE_VALUE = new HashMap<>(){
        {
            put("A","Z"); put("B","Y");put("C","X");put("D","W");put("E","V");put("F","U");put("G","T");put("H","S");put("I","R");put("J","Q");put("K","P");put("L","O");put("M","N");
            put("N","M"); put("O","L");put("P","K");put("Q","J");put("R","I");put("S","H");put("T","G");put("U","F");put("V","E");put("W","D");put("X","C");put("Y","B");put("Z","A");
        }
    };
    public static String solution(String word) {
        Stream<String> splitList = Arrays.stream(word.split("")) ;
        String switchWord = splitList.map(Problem4::switchValue).collect(Collectors.joining(""));
        return switchWord.replaceAll("null", " ");
    }
    protected static String switchValue(String originVal){
        if(originVal.equals(originVal.toUpperCase())){
            return REVERSE_VALUE.get(originVal);
        } else if (originVal.equals(originVal.toLowerCase())) {
            return REVERSE_VALUE.get(originVal.toUpperCase()).toLowerCase();
        } else {
            return "";
        }
    }
}
