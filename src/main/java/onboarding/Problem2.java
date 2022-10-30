package onboarding;

import java.util.Stack;

public class Problem2 {

    static Stack<String> stack = new Stack<>();
    static String topValue;

    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    public static String conversionStackString(){
        String returnString = "";

        for(int index=0; index < stack.size(); index++){
            returnString += stack.get(index);
        }

        return returnString;
    }

    public static void checkAndPush(String currentValue, String topValue){
        boolean checkSameValue;

        checkSameValue = isSameValue(currentValue, topValue);

        if (checkSameValue == false){
            stack.push(currentValue);
        }

    }

    public static void checkAndPop(String currentValue, String topValue){
        boolean checkSameValue;

        checkSameValue = isSameValue(currentValue, topValue);

        if (checkSameValue){
            stack.pop();
        }

    }


    public static boolean isSameValue(String currentValue, String topValue){
        boolean checkValue = false;

        if (currentValue == topValue){
            checkValue = true;
        }

        return checkValue;
    }

    public static String checkTopValue(Stack checkStack){
        String tempTopValue = "";

        if (isEmpty(checkStack) == false){
            tempTopValue = (String) checkStack.peek();
        }

        return tempTopValue;
    }

    public static boolean isEmpty(Stack checkStack){
        boolean returnBoolean = false;

        if (checkStack.isEmpty()){
            returnBoolean = true;
        }

        return returnBoolean;
    }
}
