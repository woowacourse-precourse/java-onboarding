package onboarding;

import java.util.LinkedList;

public class Problem2 {
    // func : get rid of successive char and return result
    private static String decode(String string){

        // string for result
        String res = "";
        // for memorize prior char
        char priorChar = ' ';
        for (int i=0;i<string.length()-1;i++){

            // append char if not successive
            if ((priorChar != string.charAt(i)) && !(string.charAt(i) == string.charAt(i+1)))
                res += string.charAt(i);

            // refresh char
            priorChar = string.charAt(i);
        }
        // for last char
        char lastChar = string.charAt(string.length() - 1);
        if (priorChar != lastChar)
            res += lastChar;

        return res;
    }
    // func : check need to more decode
    private static Boolean checkStr(String string){
        for (int i=0;i<string.length()-1;i++)
            if (string.charAt(i) == string.charAt(i+1))
                return false;
        return true;
    }
    // func : recursive decoding algorithm return decoded string
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
