package onboarding;

import java.util.Stack;

public class Problem2 {

    static Stack<String> stack;
    static String topValue;

    public static String solution(String cryptogram) {
        stack = new Stack<>();

        String answer = "";
        String currentValue;
        String topValue;

        for (int index=0; index < cryptogram.length(); index++){
            currentValue = String.valueOf(cryptogram.charAt(index));
            topValue = checkTopValue();
            checkAndPush(currentValue, topValue);
            checkAndPop(currentValue, topValue);
        }

        answer = conversionStackString();

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

        if (currentValue.equals(topValue)){
            checkValue = true;
        }

        return checkValue;
    }

    public static String checkTopValue(){
        String tempTopValue = "";

        if (!isEmpty()){
            tempTopValue = stack.peek();
        }

        return tempTopValue;
    }

    public static boolean isEmpty(){
        boolean returnBoolean = false;

        if (stack.isEmpty()){
            returnBoolean = true;
        }

        return returnBoolean;
    }
}
