package onboarding.solution2;

import java.util.*;

public class TypeChanger {
    public static char[] stringToCharArray (String sentence){
        char[] res = sentence.toCharArray();
        return res;
    }

    public static String stackToString (Stack<Character> stack){
        String res = "";
        int size = stack.size();
        for (int i = 0; i < size; i++){
            res += stack.get(i);
        }
        return res;
    }
}
