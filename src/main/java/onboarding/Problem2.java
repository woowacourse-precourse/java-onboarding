package onboarding;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String stackToString(Stack<String> stack){
        return stack.stream()
                .reduce("",(a,b)->a+b);
    }

    public static List<String> getStringList(String cryptogram){
        return Stream.of(cryptogram.split(""))
                .collect(Collectors.toList());
    }

    public static Stack<String> doStack(List<String> stringList){
        Stack<String> stack =new Stack<>();
        for (String s : stringList) {
            if (stack.isEmpty()){
                stack.push(s);
                continue;
            }
            if (stack.lastElement().equals(s)){
                stack.pop();
                continue;
            }
            stack.push(s);
        }
        return stack;
    }
}
