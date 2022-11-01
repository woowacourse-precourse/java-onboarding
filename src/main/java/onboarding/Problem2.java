package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "";
        String[] crypto = cryptogram.split("");
        List<String> question = new ArrayList<>(Arrays.asList(crypto));
        Stack stack = new Stack();
        for (String q : question)
            stack.push(q);


        while (true) {

            Stack newStack = calculation(stack);

            if(stack.size() == 0 ||check(newStack)){
                for(int i = 0 ; i < newStack.size(); i ++){
                    answer += newStack.get(i);
                }
                break;
            }

            stack = newStack;
        }


        return answer;
    }

    public static boolean check(Stack stack){
        for (int i = 0 ; i < stack.size() -1; i ++){
            if(String.valueOf(stack.get(i)).equals(String.valueOf(stack.get(i+1)))){
                return false;
            }
        }
        return true;
    }

    public static Stack calculation( Stack stack) {
        List<String> crypto = new ArrayList<>(stack);
        Stack returnStack = new Stack();
        String last = crypto.get(0);
        returnStack.push(crypto.get(0));
        boolean sameLast = false;
        for (int i = 1; i < crypto.size(); i++) {
            if (!(last.equals(crypto.get(i)))) {
                if (sameLast == true)
                    returnStack.pop();

                returnStack.push(crypto.get(i));
                last = crypto.get(i);
                sameLast = false;
            } else {
                sameLast = true;
            }
        }
        if(sameLast == true){
            returnStack.pop();
        }
        return returnStack;
    }
}
