package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;
//성공
public class Problem2 {
    public static String solution(String s) {


        int answer = -1;
        char[] carr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<carr.length;i++) {
            char c = carr[i];

            if (stack.isEmpty()) stack.push(c);

            else {

                if (stack.peek() == c) {
                    stack.pop();

                } else {
                    stack.push(c);
                }
            }
        }

        String a ="";

        for(char i:stack){
            a+=i;
        }


        return a;
    }


}
