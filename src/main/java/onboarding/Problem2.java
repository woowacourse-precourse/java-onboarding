package onboarding;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] ch = cryptogram.toCharArray();
        while(check1(ch) & check2(ch)){
            Stack<Character> decodeStack = dremove(ch);
            String answer = stacktostr(decodeStack);
            return answer;

        }
        return answer;
    }

    public static boolean check1(char[] num){                                  // 중복 있는지 없는지 체크
        for(int i =0; i<num.length -1; i++){
            if(num[i] == num[i+1]){
                return true;
            }
        }
        return false;
    }

    public static boolean check2(char[] num){                                  //길이 1이상 1000이하
        if(num.length >=1 &&num.length <= 1000){
            return true;
        }else{
            return false;
        }
    }


    public static Stack<Character> dremove(char[] nu) {
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

    public static String stacktostr(Stack<Character> stack){                    // string형으로 변환
        StringBuilder stringBuilder = new StringBuilder();

        for ( char c : stack){
            stringBuilder.append(c);

        }
        return stringBuilder.toString();
    }




}
