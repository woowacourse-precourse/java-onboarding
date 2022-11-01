package onboarding;
import java.util.Stack; //import

public class Problem2 {
    public static String stackReverse (Stack<Character> stack)
    {
        // 스택을 뒤집어 String 으로 반환하는 함수.
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
            // stack 이 비어있을 때 알파벳 삽입
            if (stack.isEmpty())
                stack.push(cryptogram.charAt(i));
            else {
                if (stack.peek() == cryptogram.charAt(i))
                {
                    // 알파벳 중복되면 삽입하지않는다.
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
