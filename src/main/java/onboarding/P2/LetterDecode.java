package onboarding.P2;

import java.util.Stack;


public class LetterDecode {

    public static String RecursionDeCode(String cyptogram){
        char[] ch = cyptogram.toCharArray();
        if(DuplicateCheck(ch)){
            Stack<Character> decodeStack = PwDecoder(ch);
            String answer = StackToString(decodeStack);
            return RecursionDeCode(answer);
        }
        return cyptogram;
    }

    private static boolean DuplicateCheck(char[] num){                                  // 중복 있는지 없는지 체크
        for(int i =0; i<num.length -1; i++){
            if(num[i] == num[i+1]){
                return true;
            }
        }
        return false;
    }

    private static Stack<Character> PwDecoder(char[] nu) {
        char decode = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : nu) {

            if (decode != c) {
                stack.push(c);
                decode = c;
            } else if (decode == stack.peek() ) {                      //stack.peek()  제일 상단에 있는 값을 빼지 않고 반환
                stack.pop();
            }
        }
        return stack;
    }
    private static String StackToString(Stack<Character> stack){
        StringBuilder stringBuilder = new StringBuilder();

        for ( char c : stack){
            stringBuilder.append(c);

        }
        return stringBuilder.toString();
    }
}


