package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        Stack<Character> stack = new Stack<>();

        char[] cryptogramArray = cryptogram.toCharArray();

        for (char c : cryptogramArray) {

            // 만약 stack이 비어있으면 무조건 넣기
            if(stack.isEmpty())
            {
                stack.add(c);
            }
            else{

                Character peek = stack.peek();
                // 스택의 끝에 같은 문자가 있다면 중복으로 생각하고 제거
                if(peek.equals(c))
                {
                    stack.pop();
                }
                // 만약 없다면 stack에 추가
                else{
                    stack.add(c);
                }
            }
        }

        int size = stack.size();
        StringBuilder sb = new StringBuilder();

        for(int i =0; i < size; i++)
        {
            sb.append(stack.pop());
        }

        String answer = sb.reverse().toString();
        return answer;
    }
}
