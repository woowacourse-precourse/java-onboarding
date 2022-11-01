package onboarding;
import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeDuplicateChar(cryptogram);
        return answer;
    }

    private static String removeDuplicateChar(String string){//연속하는 중복 제거
        Stack<Character> resultStringStack= makeStackNoDuplicateChar(string);
        return stackToString(resultStringStack);
    }
    private static Stack<Character> makeStackNoDuplicateChar(String string) {// 연속하는 중복 문자들 제거한 스택
        Stack<Character> resultStringStack = new Stack<>();
        Character prevChar;
        Character currentChar;
        int i=0;
        while (i < string.length()) {
            currentChar = string.charAt(i);
            if(resultStringStack.empty()){
                resultStringStack.push(currentChar);
                i++;
            }
            else{
                prevChar = resultStringStack.peek();
                if(prevChar.equals(currentChar)){//같은 문자면 제거
                    while(i<string.length() && prevChar.equals(string.charAt(i))){//다른문자 나올때까지 한칸씩 이동
                        i++;
                    }
                    resultStringStack.pop();
                }
                else{// 같은문자 아니면 스택에 push
                    resultStringStack.push(currentChar);
                    i++;
                }
            }
        }
        return resultStringStack;
    }

    private static String stackToString(Stack<Character> stack){// stack을 string형태로 변환
        return stack.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
