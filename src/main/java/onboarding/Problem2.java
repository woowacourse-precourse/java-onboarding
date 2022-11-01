package onboarding;
import java.util.Stack; //import

public class Problem2 {
    public static String stackReverse (Stack<Character> stack)
    {

        String  answer ="";
        while (!stack.isEmpty()){
            answer += stack.pop();
        }
        StringBuffer sb = new StringBuffer(answer);
        String reversedAnswer = sb.reverse().toString();
        return reversedAnswer;
    }

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i< cryptogram.length(); i++)
        {
            if (stack.isEmpty())
                stack.push(cryptogram.charAt(i));
            else {
                if (stack.peek() == cryptogram.charAt(i))
                {
                    while (i < cryptogram.length() && stack.peek() == cryptogram.charAt(i))
                        i++;
                    stack.pop();
                    i--;
                    continue;
                }
                else
                    stack.push(cryptogram.charAt(i));
            }
        }
        return stackReverse(stack);
    }
}
