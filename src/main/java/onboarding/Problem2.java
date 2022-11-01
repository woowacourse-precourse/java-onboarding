package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> duplicateChecker = new Stack<>();
        char[] cryptogramChars = cryptogram.toCharArray();
        if (exception(cryptogram)) {
            for(int index=0; index<cryptogramChars.length; index++) {
                if (index==0 || duplicateChecker.empty()) {
                    duplicateChecker.push(cryptogramChars[index]);
                }else if (duplicateChecker.peek() == cryptogramChars[index]) {
                    duplicateChecker.pop();
                }else{
                    duplicateChecker.push(cryptogramChars[index]);
                }
            }

            if(!duplicateChecker.empty()) {
                for(char cryptogramChar : duplicateChecker) {
                    answer += "" + cryptogramChar;
                }
            }
        }
    return answer;
    }


    private static boolean exception(String cryptogram) {
        if(cryptogram.length() < 1 || cryptogram.length() > 1000){
            return false;
        }
        for (int i = 0; i < cryptogram.length(); i++) {
            if (Character.isUpperCase(cryptogram.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
