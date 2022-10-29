package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        answer = eliminate(cryptogram,0,Character.MIN_VALUE, false);

        return answer;
    }

    private static String eliminate(String cryptogram, int index, char before, boolean founded){
        if(index + 1 > cryptogram.length()){
            if(founded==true) {
                return eliminate(cryptogram,0, Character.MIN_VALUE, false);
            }
            else return cryptogram;
        }
        else{
            char current = cryptogram.charAt(index);

            if(before == current){
                String part1 = cryptogram.substring(0, index-1);
                String part2 = cryptogram.substring(index+1);
                return eliminate(part1+part2, index-1, current, true);
            }
            else
                return eliminate(cryptogram, index+1, current, founded);
        }
    }
}
