package onboarding;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> stringList = getStringList(cryptogram);
        return stackToString(doStack(stringList));
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
            checkStackCondition(stack,s);
        }
        return stack;
    }

    public static void checkStackCondition(Stack<String> stack,String s){
        if (stack.isEmpty()){
            stack.push(s);
            return;
        }

        if (stack.lastElement().equals(s)){
            stack.pop();
            return;
        }

        stack.push(s);
    }
}
