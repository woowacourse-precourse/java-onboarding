package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        Stack<Character> stack = new Stack<>();
        stack.push(cryptogram.charAt(0));   // 첫번째는 항상 stack에 삽입해야한다.

        removeSame(cryptogram, stack);

        return extracted(stack);

    }


    public static void removeSame(String cryptogram, Stack<Character> stack) {   // 나란히 반복되는 문자열 삭제 기능
        int i=1;

        while (i< cryptogram.length()){

            if (stack.peek()== cryptogram.charAt(i)){
                i++;

                if(i == cryptogram.length() || stack.peek()!= cryptogram.charAt(i)){
                    stack.pop();
                }
            }
            else{
                stack.push(cryptogram.charAt(i));
                i++;
            }


        }
    }

    public static String extracted(Stack<Character> stack) {  //stack 내부 값을 문자열로 추출해주는 기능

        int j = 0;
        String answer="";
        while(stack.size()!=0){

            answer = stack.pop()+ answer;
            j++;

        }
        return answer;
    }
}
