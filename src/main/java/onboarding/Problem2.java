package onboarding;

import onboarding.problem2.DuplicationEliminator;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        while (true) {
            cryptogram = DuplicationEliminator.remove(cryptogram,stack);
            if (!DuplicationEliminator.isDuplicate(cryptogram)) {
                break;
            }
        }
        return cryptogram;
    }

}

