package onboarding;

import java.util.Stack;

public class Problem2 {

    private static boolean IsSmallAlpha(char c)
    {
        return 'a' <= c && c <= 'z';
    }

    private static boolean checkParam(String s)
    {
        if (s == null)
            return true;
        for (int i=0; i<s.length(); i++)
            if (!IsSmallAlpha(s.charAt(i)))
                return true;
        return false;
    }

    private static String makeAnswer(Stack<Character> s)
    {
        String result = "";
        Stack<Character> temp = new Stack<>();
        while (!s.isEmpty())
        {
            temp.push(s.peek());
            s.pop();
        }
        while (!temp.isEmpty())
        {
            result += temp.peek();
            temp.pop();
        }
        return result;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> cryptogramStack = new Stack<>();
        char overlapChar = '0';

        if (checkParam(cryptogram))
            return "";
        for (int i=0; i<cryptogram.length(); i++)
        {
            char index = cryptogram.charAt(i);
            if (overlapChar == index)
                continue;
            else if (!cryptogramStack.isEmpty() && cryptogramStack.peek() == index) {
                cryptogramStack.pop();
                overlapChar = index;
            } else {
                cryptogramStack.push(index);
                overlapChar = '0';
            }
        }
        answer = makeAnswer(cryptogramStack);
        return answer;
    }
}
