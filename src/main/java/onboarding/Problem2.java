package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> word = new ArrayList<>(Arrays.asList(cryptogram.split(""))); // String 을 배열로
        List<String> stack = new ArrayList<>();
        while(!word.isEmpty()) {
            if(stack.isEmpty()) { // 스택이 비어 있으면 그냥 넣는다
                stack.add(word.get(0));
            }
            else { // 스택에 문자가 있을 때
                if(stack.get(stack.size() - 1).equals(word.get(0))) // 넣을 문자와 같으면 스택 맨 위 문자 제거
                    stack.remove(stack.size() - 1);
                else stack.add(word.get(0)); // 넣을 문자와 다르면 스택에 넣는다
            }
            word.remove(0);
        }
        return String.join("", stack);
    }
}
