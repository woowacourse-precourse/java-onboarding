package onboarding.problem2;

import java.util.Stack;

public class StackGenerator {

    public Stack<String> createStack(String cryptogram) {

        Stack<String> stack = new Stack<>();
        String[] split = cryptogram.split("");

        stack.push(split[0]);


        for (int i = 1; i < split.length; i++) {

            if (stack.size() > 0 && stack.peek().equals(split[i])) {
                stack.pop();
            } else {
                stack.push(split[i]);
            }

//            stack.push(split[i]);
//
//            String pop1 = stack.pop();
//            String pop2 = stack.pop();
//
//            if (pop1.equals(pop2)) {
//                continue;
//            }
//
//            stack.push(pop2);
//            stack.push(pop1);
        }

        return stack;
    }
}
