package onboarding;

import onboarding.solution2.*;
import java.util.Stack;


public class Problem2 {
    public static String solution(String cryptogram) {
        int len = cryptogram.length();
        if (len == 0){
            return cryptogram;
        }
        TypeChanger change = new TypeChanger();
        RedundantChecker checker = new RedundantChecker();
        char[] str = change.stringToCharArray(cryptogram);
        Stack<Character> result = checker.removeRedundancy(str);
        if (result.empty() == true){
            return "";
        }
        String answer = change.stackToString(result);
        return answer;
    }
}
