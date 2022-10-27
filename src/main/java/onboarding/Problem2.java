package onboarding;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] ch = cryptogram.toCharArray();
        while(check(ch)){
            Stack<Character> decodeStack = dremove(ch);                       //?

        }
        return answer;
    }

    public static boolean check(char[] num){                                  // 중복 있는지 없는지 체크
        for(int i =0; i<num.length -1; i++){
            if(num[i] == num[i+1]){
                return true;
            }
        }
        return false;
    }


    public static String dremove(char[] nu) {
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




}
