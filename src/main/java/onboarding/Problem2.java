package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> word = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        List<String> stack = new ArrayList<>();
        while(!word.isEmpty()) {
            if(stack.isEmpty()) {
                stack.add(word.get(0));
            }
            else { // 스택에 문자가 있을 때
                if(stack.get(stack.size() - 1).equals(word.get(0))) {
                    stack.remove(stack.size() - 1);
                }
                else {
                    stack.add(word.get(0));
                }
            }
            word.remove(0);
        }
        return String.join("", stack);
    }
}
